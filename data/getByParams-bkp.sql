create or replace function diffdate (date1 in date, date2 in date)
    return number is
    begin 
        return date2-date1;
    end;
    
select candidate_profile.cdt_id, candidate_profile.cdt_first_name,
    (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days,
    (select
        sum(to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days_total
        from candidate_profile, experience, candidate_experience
        where candidate_experience.cdt_id = candidate_profile.cdt_id and candidate_experience.exp_id = experience.exp_id
        and candidate_profile.cdt_id = 1)
    as exp_total
    from candidate_profile, candidate_experience, experience 
    where candidate_profile.cdt_id = candidate_experience.cdt_id and experience.exp_id = candidate_experience.exp_id;

select exp_company, exp_title, exp_start, exp_end, (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy'))
    as exp_days from experience;

select cdt_first_name, cdt_email, experience.exp_title, experience.exp_company, experience.exp_start, experience.exp_end,
    (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days
    from candidate_profile, experience, candidate_experience
    where candidate_experience.cdt_id = candidate_profile.cdt_id and candidate_experience.exp_id = experience.exp_id
    and candidate_profile.cdt_id = 1;
    
select
    sum(to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days
    from candidate_profile, experience, candidate_experience
    where candidate_experience.cdt_id = candidate_profile.cdt_id and candidate_experience.exp_id = experience.exp_id
    and candidate_profile.cdt_id = 1;
    
select cdt_cpf, cdt_first_name, cdt_email, cdt_gender, cdt_phone, (select
    sum(to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days
    from candidate_profile, experience, candidate_experience
    where candidate_experience.cdt_id = candidate_profile.cdt_id and candidate_experience.exp_id = experience.exp_id
    and candidate_profile.cdt_id = 1) as exp_total from candidate_profile where candidate_profile.cdt_id = 1;
    
select candidate_profile.cdt_cpf, candidate_profile.cdt_first_name from
    candidate_profile, candidate_experience where candidate_experience.cdt_id = candidate_profile.cdt_id
    group by (candidate_profile.cdt_cpf, candidate_profile.cdt_first_name);
    


/*create or replace function get_candidate_by_experience (experience_year number)
    return SYS_REFCURSOR is
    candidates_list SYS_REFCURSOR;
    begin
        open candidates_list for
        select *
        from
        (
          SELECT
            candidate_profile.cdt_first_name,
            experience.exp_start,
            experience.exp_end,
            (experience.exp_end - experience.exp_start) as experience_number
          FROM candidate_profile, experience
        ) x
        where experience_number <= experience_year;
    return candidates_list;
end;

SELECT get_candidate_by_experience(7) FROM DUAL;*/

--select * from candidate_profile, (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 100))) endereco
--    where candidate_profile.address_adr_id = endereco.adr_id;
