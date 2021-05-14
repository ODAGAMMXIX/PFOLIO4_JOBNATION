package com.tecnocode.repository;

import com.tecnocode.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchByParamsRepository extends JpaRepository<Candidate, Integer> {
    @Query(value = "Select candidate_profile.*, candidate_profile.*, language.*, qualification.*, " +
            "skill.*, endereco.*, " +
            "(to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days FROM candidate_profile, " +
            "candidate_experience, experience, language, candidate_language, " +
            "qualification, candidate_qualification, skill, candidate_skill, " +
            "(SELECT * FROM TABLE(get_address_by_lat_long( ?2 , ?3 , ?4 ))) endereco ?1 ;", nativeQuery = true)

    List<Object[]> searchByParams(String query, Float lat, Float lng, Integer range_distance);

}
