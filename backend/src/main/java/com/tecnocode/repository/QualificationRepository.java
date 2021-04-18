package com.tecnocode.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tecnocode.model.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
	@Query("SELECT v FROM Qualification v WHERE v.name like :name")
	List<Qualification> findAllByName(@Param("name") String name);

	@Query("SELECT v FROM Qualification v WHERE v.level like :level")
	List<Qualification> findAllByLevel(@Param("level") String level);

	@Query("SELECT v FROM Qualification v WHERE v.institution like :institution")
	List<Qualification> findAllByInstitution(@Param("institution") String institution);

	@Query("SELECT v FROM Qualification v WHERE v.start <= :start AND v.start IS NOT NULL")
	List<Qualification> findAllByStart(@Param("start") LocalDate start);

	@Query("SELECT v FROM Qualification v WHERE v.end >= :end AND v.end IS NOT NULL")
	List<Qualification> findAllByEnd(@Param("end") LocalDate end);

	@Query("SELECT v FROM Qualification v WHERE v.status like :status")
	List<Qualification> findAllByStatus(@Param("status") String status);
}
