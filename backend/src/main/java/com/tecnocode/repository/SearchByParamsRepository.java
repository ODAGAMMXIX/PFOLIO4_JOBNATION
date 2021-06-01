package com.tecnocode.repository;

import com.tecnocode.model.Candidate;
import com.tecnocode.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchByParamsRepository extends JpaRepository<Candidate, Integer> {
//    @Query(value = "Select candidate_profile.* " +
//            "        from candidate_profile, experience, candidate_experience, " +
//            "        (SELECT * FROM TABLE(get_address_by_lat_long(?2, ?3, ?4))) endereco where ?1", nativeQuery = true)
//    List<Object> searchByParams(String query,
//                                Float lat,
//                                Float lng,
//                                Integer range_distance);


    @Query(value=
            "SELECT distinct candidate.firstName " +
                    "FROM Candidate candidate " +
                    "JOIN candidate.experience experience " +
                    "JOIN candidate.qualification qualification " +
                    "JOIN candidate.skill skill " +
                    "JOIN candidate.language language " +
                    "WHERE (?1 is null or qualification.level IN (?1))" +
                    "AND (?2 is null or skill.name IN (?2))" +
                    "AND (?3 is null or language.name IN (?3))" +
                    "AND (?4 is null or candidate.gender = ?4)", nativeQuery = true
    )
    List<Object> searchAllCandidates(
            List<String> levels,
            List<String> skills,
            List<String> languages,
            String gender
    );

}
