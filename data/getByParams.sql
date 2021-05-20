/*
	{
		"distance": 20, -- em k,=m
		"experience": 2, -- em anos*
		"genre": "masculino",
		"language": "ingles",
		"qualification": "Ensino superior",
		"skill": "HTML",
        "lat": -23.1622, -- lat da vaga
        "lng": -45.7953, -- lng da vaga
	}
*/

select * from candidate_profile, (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 100))) endereco
    where candidate_profile.address_adr_id = endereco.adr_id;

select candidate_profile.*, candidate_profile.*, language.*, qualification.*,
    skill.*, address.*
        from candidate_profile, candidate_experience, experience, language, candidate_language,
        qualification, candidate_qualification, skill, candidate_skill,
            (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 20))) address,
            (SELECT candidate_experience.cdt_id
                from experience, candidate_experience where experience.exp_id = candidate_experience.exp_id
                    and (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * 1)
                    group by candidate_experience.cdt_id) experience
            where candidate_profile.cdt_id = candidate_experience.cdt_id
                and experience.exp_id = candidate_experience.exp_id
                and candidate_profile.cdt_gender = 'masculino'
                and candidate_language.cdt_id = candidate_profile.cdt_id
                and candidate_language.lan_id = language.lan_id
                and language.lan_name = 'Inglês'
                and qualification.qua_level_degr = 'Superior'
                and candidate_qualification.qua_id = qualification.qua_id
                and candidate_qualification.cdt_id = candidate_profile.cdt_id
                and skill.ski_name = 'HTML'
                and candidate_skill.ski_id = skill.ski_id
                and candidate_skill.cdt_id = candidate_profile.cdt_id
                and candidate_profile.address_adr_id = address.adr_id
                and experience.cdt_id = candidate_profile.cdt_id;
                
select candidate_experience.cdt_id
    from experience, candidate_experience where experience.exp_id = candidate_experience.exp_id
        and (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * 1)
        group by candidate_experience.cdt_id;
		
--Buscar candidado por experiência
select candidate_profile.*
    from candidate_profile,
    (SELECT candidate_experience.cdt_id
        from experience, candidate_experience where experience.exp_id = candidate_experience.exp_id
            and (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * 1)
            group by candidate_experience.cdt_id) experience
    where candidate_profile.cdt_id = experience.cdt_id;

-- Subselect Buscar candidato por skill
SELECT candidate_profile.cdt_id
    from candidate_profile, candidate_skill, 
        (select * from skill where skill.ski_name in ('HTML', 'PHP')) skills
    where candidate_profile.cdt_id = candidate_skill.cdt_id
        and skills.ski_id = candidate_skill.ski_id group by candidate_profile.cdt_id;

--Subselect candidato por idioma e nível    
SELECT candidate_profile.cdt_id
    from candidate_profile, candidate_language,
        (select * from language where language.lan_name in ('Inglês', 'Alemão')) languages_names,
        (select * from language where language.lan_level in ('Fluente', 'Intermediário')) languages_level
    where candidate_profile.cdt_id = candidate_language.cdt_id
        and languages_level.lan_id = candidate_language.lan_id
        and languages_names.lan_id = candidate_language.lan_id group by candidate_profile.cdt_id;

--Subselect candidato por graduação e status    
SELECT candidate_profile.cdt_id
    from candidate_profile, candidate_qualification,
        (select * from qualification where qualification.qua_level_degr in ('Superior', 'Profissionalizante')) qualifications_level,
        (select * from qualification where qualification.qua_status in ('Cursando')) qualifications_status
    where candidate_profile.cdt_id = candidate_qualification.cdt_id
        and qualifications_status.qua_id = candidate_qualification.qua_id
        and qualifications_level.qua_id = candidate_qualification.qua_id group by candidate_profile.cdt_id;

--Subselect candidato por distância
SELECT candidate_profile.cdt_id
    from candidate_profile,
        (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 100))) endereco
    where candidate_profile.address_adr_id = endereco.adr_id group by candidate_profile.cdt_id;

--Subselect candidato por distância    
SELECT candidate_profile.cdt_id 
    from candidate_profile 
    where candidate_profile.cdt_gender in ('masculino');
        
    

    
    