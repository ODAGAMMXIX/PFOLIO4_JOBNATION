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
    skill.*, endereco.*, 
    (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days
        from candidate_profile, candidate_experience, experience, language, candidate_language,
        qualification, candidate_qualification, skill, candidate_skill,
            (SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 20))) endereco
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
                and candidate_profile.address_adr_id = endereco.adr_id
                and (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * 2);