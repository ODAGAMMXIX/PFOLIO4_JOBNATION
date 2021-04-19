package com.tecnocode.repository;

import com.tecnocode.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer>{
    @Query("SELECT v FROM Vacancy v WHERE v.company like :company")
    List<Vacancy> findAllByCompany(@Param("company") Company company);

    @Query("SELECT v FROM Vacancy v WHERE v.address like :address")
    List<Vacancy> findAllByAddress(@Param("address") Address address);

    @Query("SELECT v FROM Vacancy v WHERE v.title like :title")
    List<Vacancy> findAllByTitle(@Param("title") String title);

    @Query("SELECT v FROM Vacancy v WHERE v.minSalary >= :minSalary")
    List<Vacancy> findAllByMinSalary(@Param("minSalary") Double minSalary);

    @Query("SELECT v FROM Vacancy v WHERE v.maxSalary <= :maxSalary")
    List<Vacancy> findAllByMaxSalary(@Param("maxSalary") Double maxSalary);

    @Query("SELECT v FROM Vacancy v WHERE v.openDate <= :openDate AND v.openDate IS NOT NULL")
    List<Vacancy> findAllByOpenDate(@Param("openDate") LocalDate openDate);

    @Query("SELECT v FROM Vacancy v WHERE v.closeDate >= :closeDate AND v.closeDate IS NOT NULL")
    List<Vacancy> findAllByCloseDate(@Param("closeDate") LocalDate closeDate);

    @Query("SELECT v FROM Vacancy v WHERE v.experiences like :experiences")
    List<Vacancy> findAllByExperience(@Param("experiences") Experience experiences);

    @Query("SELECT v FROM Vacancy v WHERE v.qualifications like :qualifications")
    List<Vacancy> findAllByQualification(@Param("qualifications") Qualification qualifications);

    @Query("SELECT v FROM Vacancy v WHERE v.skills like :skills")
    List<Vacancy> findAllBySkill(@Param("skills") Skill skills);

    @Query("SELECT v FROM Vacancy v WHERE v.languages like :languages")
    List<Vacancy> findAllByLanguage(@Param("languages") Language languages);

    @Query("SELECT v FROM Vacancy v WHERE v.benefits like :benefits")
    List<Vacancy> findAllByBenefit(@Param("benefits") Benefit benefits);
}
