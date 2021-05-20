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
    @Query(value = "Select candidate_profile.* " +
            "        from candidate_profile, experience, candidate_experience, " +
            "        (SELECT * FROM TABLE(get_address_by_lat_long(?2, ?3, ?4))) endereco where ?1", nativeQuery = true)
    List<Object> searchByParams(String query,
                                Float lat,
                                Float lng,
                                Integer range_distance);


    @Query(
            "SELECT distinct candidate.firstName " +
                    "FROM Candidate candidate " +
                    "JOIN candidate.experiences experiences " +
                    "JOIN candidate.qualifications qualifications " +
                    "JOIN candidate.skills skills " +
                    "JOIN candidate.languages languages " +
                    "WHERE (:levels is null or qualifications.level IN (:levels))" +
                    "AND (:skils is null or skills.name IN (:skils))" +
                    "AND (:languages is null or languages.name IN (:languages))" +
                    "AND (:gender is null or candidate.gender = :gender)" +
                    "AND (:exp is null or (to_date(experiences.end,'dd/MM/yyyy') - to_date(experiences.start,'dd/MM/yyyy')) >= :exp)" +
                    "AND (:range is null or candidate.address  get_address_by_lat_long(:lat, :lng, :range))"
    )
    List<String> searchAllCandidates(
            @Param("levels") List<String> levels,
            @Param("skils") List<String> skils,
            @Param("languages") List<String> languages,
            @Param("gender") String gender,
            @Param("exp") Double exp,
            @Param("lat") Double lat,
            @Param("lng") Double lng,
            @Param("range") Integer range
    );

}
