drop type output_address;        
drop type output_address_return;

create or replace type output_address_return is
    object(
        adr_id number (10,0),
        adr_cep_pczc varchar(255),
        adr_detail varchar(255),
        adr_num varchar(255),
        adr_hood varchar(255),
        adr_city varchar(255),
        adr_state varchar(255),
        adr_lat float,
        adr_long float,
        adr_distance float
    );
    
create or replace type output_address as table of output_address_return;       

create or replace function get_address_by_lat_long (vacancy_lat float, vacancy_long float, range_distance number)
    return output_address PIPELINED is
    begin
        for RECORD_OUTPUT IN (
        select *
        from
        (
          SELECT
            adr_id,
            adr_lat,
            adr_long,
            adr_cep_pczc,
            adr_detail,
            adr_num,
            adr_hood,
            adr_city,
            adr_state,
            TRUNC((
               6371 *  -- em quilómetros
               acos(cos((vacancy_lat * 3.14)/ 180) * --latitude da vaga -23.1622
               cos((adr_lat * 3.14)/ 180) * 
               cos((adr_long * 3.14)/ 180 - 
               (vacancy_long * 3.14)/ 180) + --longitude da vaga -23.1622
               sin((vacancy_lat * 3.14)/ 180) * 
               sin((adr_lat * 3.14)/ 180))
            ), 1) AS distance 
          FROM address
        ) x
        where distance <= range_distance AND distance > 0)-- quilómetros
        LOOP
            PIPE ROW (output_address_return(
				RECORD_OUTPUT.adr_id,
				RECORD_OUTPUT.adr_cep_pczc,
				RECORD_OUTPUT.adr_detail,
				RECORD_OUTPUT.adr_num,
				RECORD_OUTPUT.adr_hood,
				RECORD_OUTPUT.adr_city,
				RECORD_OUTPUT.adr_state,
				RECORD_OUTPUT.adr_lat,
				RECORD_OUTPUT.adr_long,
				RECORD_OUTPUT.distance
			));
        END LOOP;
end;

--SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 10));

select * from candidate_profile, (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 100))) endereco
    where candidate_profile.address_adr_id = endereco.adr_id;

--SELECT candidate_profile.cdt_name, (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 10))) AS address_list from address_list, candidate_profile  where address_list.adr_id = candidate_profile.address_adr_id; 
        
/*create or replace function get_address_by_lat_long_cursor (vacancy_lat float, vacancy_long float, range_distance number)
    return SYS_REFCURSOR is
    address_list SYS_REFCURSOR;
    begin
        open address_list for
        select *
        from
        (
          SELECT
            adr_id,
            adr_lat,
            adr_long,
            adr_cep_pczc,
            adr_detail,
            adr_num,
            adr_hood,
            adr_city,
            adr_state,
            TRUNC((
               6371 *  -- em quilómetros
               acos(cos((vacancy_lat * 3.14)/ 180) * --latitude da vaga -23.1622
               cos((adr_lat * 3.14)/ 180) * 
               cos((adr_long * 3.14)/ 180 - 
               (vacancy_long * 3.14)/ 180) + --longitude da vaga -23.1622
               sin((vacancy_lat * 3.14)/ 180) * 
               sin((adr_lat * 3.14)/ 180))
            ), 1) AS distance 
          FROM address
        ) x
        where distance <= range_distance AND distance > 0; -- quilómetros
    return address_list;
end;

SELECT get_address_by_lat_long_cursor(-23.1622, -45.7953, 10) FROM DUAL;


/*
select *
from
(
  SELECT
    adr_id,
    adr_lat,
    adr_long,
    adr_cep_pczc,
    adr_detail,
    adr_num,
    adr_hood,
    adr_city,
    adr_state,
    TRUNC((
	   6371 *  -- em quilómetros
	   acos(cos((-23.1622 * 3.14)/ 180) * --latitude da vaga -23.1622
	   cos((adr_lat * 3.14)/ 180) * 
	   cos((adr_long * 3.14)/ 180 - 
	   (-45.7953 * 3.14)/ 180) + --longitude da vaga -23.1622
	   sin((-23.1622 * 3.14)/ 180) * 
	   sin((adr_lat * 3.14)/ 180))
	), 1) AS distance 
  FROM address
) x
where distance <= 10 AND distance > 0; -- quilómetros*/