drop type output_experience;        
drop type output_experience_return;

create or replace type output_experience_return is
    object(
        exp_id number (10,0),
        exp_title varchar(255),
        exp_company varchar(255),
        exp_start date,
        exp_end date
    );
    
create or replace type output_experience as table of output_experience_return;

create or replace function get_by_experience(year_number number)
    return output_experience PIPELINED is
    begin
        for RECORD_OUTPUT IN (
        SELECT * FROM experience where 
            (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * year_number))
        LOOP
            PIPE ROW (output_experience_return(
				RECORD_OUTPUT.exp_id,
				RECORD_OUTPUT.exp_title,
				RECORD_OUTPUT.exp_company,
				RECORD_OUTPUT.exp_start,
                RECORD_OUTPUT.exp_end
			));
        END LOOP;
    end;
    
SELECT * FROM TABLE(get_by_experience(2));