create or replace PROCEDURE JN_MULTIPLE_CRITERIA (
    idioma                 VARCHAR2 DEFAULT 'DEFAULT',
    nivel_idioma           VARCHAR2 DEFAULT 'DEFAULT',
    experiencia            NUMBER DEFAULT 1,
    -- vtn                 NUMBER DEFAULT 10,    
    distancia              NUMBER DEFAULT 1000000000,
    skill                  VARCHAR2 DEFAULT 'DEFAULT',
    qualification_level    VARCHAR2 DEFAULT 'DEFAULT',
    qualification_status   VARCHAR2 DEFAULT 'DEFAULT',
    gender                 VARCHAR2 DEFAULT 'masculino') is
   
    return_name    candidate_profile.cdt_first_name%TYPE;
    return_email   candidate_profile.cdt_email%TYPE;
    emp_refcur      SYS_REFCURSOR;
BEGIN
      open emp_refcur
      for
      SELECT
          cp.cdt_first_name,
          cp.cdt_email
      INTO
          return_name,
          return_email
      FROM
          candidate_profile cp,
          (SELECT candidate_profile.cdt_id
              FROM candidate_profile, candidate_qualification,
                  (SELECT * FROM qualification
                      WHERE qualification.qua_level_degr IN (qualification_level))qualifications_level,
                  (SELECT * FROM qualification
                      WHERE qualification.qua_status IN (qualification_status))qualifications_status
              WHERE
                  candidate_profile.cdt_id = candidate_qualification.cdt_id
                  AND qualifications_status.qua_id = candidate_qualification.qua_id
                  AND qualifications_level.qua_id = candidate_qualification.qua_id
              GROUP BY
                  candidate_profile.cdt_id)qualification,
          /*(SELECT candidate_profile.cdt_id
              FROM candidate_profile,
                  (SELECT * FROM ADDRESS WHERE ADR_OTHERS <= vtn) vtn_now
              WHERE
                  candidate_profile.address_adr_others = address.adr_others
              GROUP BY
                  candidate_profile.cdt_id)vtn_now_2 --ver qual é o local correto da VIEW DINAMICA,*/
          (SELECT candidate_profile.cdt_id
              FROM candidate_profile
              WHERE
                  candidate_profile.cdt_gender IN (gender))gender,
          (SELECT candidate_profile.cdt_id
              FROM candidate_profile,candidate_skill,
                  (SELECT * FROM skill
                            WHERE skill.ski_name IN (skill))skills
              WHERE
                  candidate_profile.cdt_id = candidate_skill.cdt_id
                  AND skills.ski_id = candidate_skill.ski_id
              GROUP BY
                  candidate_profile.cdt_id)skill,
          (SELECT candidate_experience.cdt_id
              FROM experience, candidate_experience
              WHERE
                  experience.exp_id = candidate_experience.exp_id
                  AND ( to_date(exp_end, 'dd/mm/yyyy') - to_date(exp_start, 'dd/mm/yyyy') ) >= ( 365 * experiencia )
              GROUP BY
                  candidate_experience.cdt_id )experience,
        (  
            SELECT candidate_profile.cdt_id
            FROM candidate_profile, candidate_language,(SELECT * FROM language WHERE language.lan_name IN(idioma))languages_names,
        (SELECT * FROM language
            WHERE
                language.lan_level IN (nivel_idioma)) languages_level
            WHERE
                candidate_profile.cdt_id = candidate_language.cdt_id
                AND languages_level.lan_id = candidate_language.lan_id
                AND languages_names.lan_id = candidate_language.lan_id
            GROUP BY
                candidate_profile.cdt_id) language
WHERE
    cp.cdt_id = experience.cdt_id
    AND cp.cdt_id = skill.cdt_id
        AND cp.cdt_id = language.cdt_id
            AND cp.cdt_id = qualification.cdt_id
               --AND cp.cdt_id = VTN_NOW OU VTN_NOW_2.cdt_id
                    AND cp.cdt_id = gender.cdt_id;
LOOP
        FETCH emp_refcur INTO return_name,return_email;
        EXIT WHEN emp_refcur%NOTFOUND;
        dbms_output.put_line('USERNAME: '
                       || return_name
                       || ' EMAIL: '
                       || return_email);
    END LOOP;


END;