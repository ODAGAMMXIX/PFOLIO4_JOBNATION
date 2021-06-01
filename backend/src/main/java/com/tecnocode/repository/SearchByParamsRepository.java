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
            "SELECT distinct candidate_profile.* " +
                    "FROM candidate_profile " +
                    "WHERE candidate_profile.cdt_gender = ?1", nativeQuery = true
    )
    List<Object> searchAllCandidates(
            String gender
    );

}
