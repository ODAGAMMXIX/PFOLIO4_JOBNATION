--V1

/*
	{
		"distance": 20, -- em k,=m
        "lat": -23.1622, -- lat da vaga
        "lng": -45.7953, -- lng da vaga
		"experience": 1, -- em anos*
		"genre": ['masculino'],
		"language": ['Inglês', 'Alemão'],
        "language_level": ['Fluente', 'Intermediário'],
		"qualification": ['Superior', 'Profissionalizante'],
        "qualification_status": ['Cursando'],
		"skill": ['HTML', 'PHP']
	}
*/

select candidate_profile.*
    from candidate_profile,
	
    (SELECT candidate_experience.cdt_id
        from experience, candidate_experience where experience.exp_id = candidate_experience.exp_id
            and (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * 1)
            group by candidate_experience.cdt_id) experience,
			
	(SELECT candidate_profile.cdt_id
		from candidate_profile, candidate_skill, 
			(select * from skill where skill.ski_name in ('HTML', 'PHP')) skills
		where candidate_profile.cdt_id = candidate_skill.cdt_id
			and skills.ski_id = candidate_skill.ski_id group by candidate_profile.cdt_id) skill,
			
	(SELECT candidate_profile.cdt_id
		from candidate_profile, candidate_language,
			(select * from language where language.lan_name in ('Inglês', 'Alemão')) languages_names,
			(select * from language where language.lan_level in ('Fluente', 'Intermediário')) languages_level
		where candidate_profile.cdt_id = candidate_language.cdt_id
			and languages_level.lan_id = candidate_language.lan_id
			and languages_names.lan_id = candidate_language.lan_id group by candidate_profile.cdt_id) language,
	
	(SELECT candidate_profile.cdt_id
		from candidate_profile, candidate_qualification,
			(select * from qualification where qualification.qua_level_degr in ('Superior', 'Profissionalizante')) qualifications_level,
			(select * from qualification where qualification.qua_status in ('Cursando')) qualifications_status
		where candidate_profile.cdt_id = candidate_qualification.cdt_id
			and qualifications_status.qua_id = candidate_qualification.qua_id
			and qualifications_level.qua_id = candidate_qualification.qua_id group by candidate_profile.cdt_id) qualification,
	
	(SELECT candidate_profile.cdt_id
		from candidate_profile,
			(SELECT * FROM TABLE(get_address_by_lat_long(-23.1622, -45.7953, 20))) address
		where candidate_profile.address_adr_id = address.adr_id group by candidate_profile.cdt_id) location,
		
	(SELECT candidate_profile.cdt_id 
		from candidate_profile 
		where candidate_profile.cdt_gender in ('masculino')) genre
	
    where candidate_profile.cdt_id = experience.cdt_id
		and candidate_profile.cdt_id = skill.cdt_id
		and candidate_profile.cdt_id = language.cdt_id
		and candidate_profile.cdt_id = qualification.cdt_id
		and candidate_profile.cdt_id = location.cdt_id
		and candidate_profile.cdt_id = genre.cdt_id;