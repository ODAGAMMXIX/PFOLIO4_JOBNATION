package com.tecnocode.repository;

import com.tecnocode.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
    @Query("SELECT c FROM Candidate c WHERE c.address like :address")
    List<Candidate> findAllByAddress(@Param("address") Address address);

    @Query("SELECT c FROM Candidate c WHERE c.experiences like :experiences")
    List<Candidate> findAllByExperience(@Param("experiences") Experience experiences);

    @Query("SELECT c FROM Candidate c WHERE c.qualifications like :qualifications")
    List<Candidate> findAllByQualification(@Param("qualifications") Qualification qualifications);

    @Query("SELECT c FROM Candidate c WHERE c.skills like :skills")
    List<Candidate> findAllBySkill(@Param("skills") Skill skills);

    @Query("SELECT c FROM Candidate c WHERE c.languages like :languages")
    List<Candidate> findAllByLanguage(@Param("languages") Language languages);

    @Query("SELECT c FROM Candidate c WHERE c.cpf like :cpf")
    List<Candidate> findAllByCpf(@Param("cpf") String cpf);

    @Query("SELECT c FROM Candidate c WHERE c.firstName like :firstName")
    List<Candidate> findAllByFirstName(@Param("firstName") String firstName);

    @Query("SELECT c FROM Candidate c WHERE c.middleName like :middleName")
    List<Candidate> findAllByMiddleName(@Param("middleName") String middleName);

    @Query("SELECT c FROM Candidate c WHERE c.surname like :surname")
    List<Candidate> findAllBySurname(@Param("surname") String surname);

    @Query("SELECT c FROM Candidate c WHERE c.gender like :gender")
    List<Candidate> findAllByGender(@Param("gender") String gender);
}
