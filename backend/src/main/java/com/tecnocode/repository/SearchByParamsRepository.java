package com.tecnocode.repository;

import com.tecnocode.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchByParamsRepository extends JpaRepository<Candidate, Integer> {
    @Query(value = "Select candidate_profile.*, experience.*, language.*, qualification.*, " +
            "skill.*, " +
            "(to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) as exp_days FROM candidate_profile, " +
            "candidate_experience, experience, language, candidate_language, " +
            "qualification, candidate_qualification, skill, candidate_skill " +
            "?1 ", nativeQuery = true)

    List<Object[]> searchByParams(@Param("query") String query,
                                  @Param("lat") Float lat,
                                  @Param("lng") Float lng,
                                  @Param("range_distance") Integer range_distance);

}
