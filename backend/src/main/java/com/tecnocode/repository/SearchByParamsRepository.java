package com.tecnocode.repository;

import com.tecnocode.model.Candidate;
import com.tecnocode.model.Qualification;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.CallableStatement;
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


    /* @Query(value=
             "SELECT distinct candidate_profile.* " +
                     "FROM candidate_profile " +
                     "WHERE candidate_profile.cdt_gender = ?1", nativeQuery = true
     )
     List<Object> searchAllCandidates(
             String gender
     );*/

    /*CallableStatement cs = connection.prepareCall(call "JN_MULTIPLE_CRITERIA ('INGLES', 'FLUENTE', 0, 10,'SCRUM', 'GRADUACAO', 'CONCLUIDO', ?1));
        cs.setInt( 1, 19652);
        cs.execute();*/

  /*  @Query(value = ("CALL (TECNOCODE.JN_MULTIPLE_CRITERIA ('DEFAULT', 'DEFAULT', 0, 10,'DEFAULT', 'DEFAULT', 'DEFAULT', ?1))"), nativeQuery = true)
    List<Object> searchAllCandidates(
            String genre);*/

    @Query(value = "SELECT candidate.* FROM TABLE(get_candidate_by_params('DEFAULT', 'DEFAULT', 0, 10, 'DEFAULT', 'DEFAULT', 'DEFAULT', ?1)) candidate", nativeQuery = true)
    List<Object> searchAllCandidates(
            String gender
            /*String idioma,
            String nivel_idioma,
            Integer experiencia,
            //-- vtn NUMBER DEFAULT 10,
            Integer distancia,
            String skill,
            String qualification_level,
            String qualification_status*/

    );

    /*@Query(value = ("CALL (TESTE123 (?,?))"), nativeQuery = true)
    List<Object> searchAllCandidates(
            String genre);*/


    /*StoredProcedureQuery query = entityManager
            .createStoredProcedureQuery("TESTE123")
            .registerStoredProcedureParameter(
                    1,
                    Long.class,
                    ParameterMode.IN
            )
            .setParameter(1, 1L);

            query.execute();

            Long commentCount = (Long) query.getOutputParameterValue(1);*/

  /* @NamedNativeQueries({
            @NamedNativeQuery(
                    name = "callStockStoreProcedure",
                    query = "CALL GetStocks(:stockCode)",
                    resultClass = Stock.class
            )
    })
    @Entity
    @Table(name = "stock")
    public class Stock implements java.io.Serializable {
   */
}