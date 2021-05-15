package com.tecnocode.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tecnocode.model.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Integer> {
	@Query("SELECT q FROM Qualification q WHERE q.name like :name")
	List<Qualification> findAllByName(@Param("name") String name);

	@Query("SELECT q FROM Qualification q WHERE q.level like :level")
	List<Qualification> findAllByLevel(@Param("level") String level);

	@Query("SELECT q FROM Qualification q WHERE q.institution like :institution")
	List<Qualification> findAllByInstitution(@Param("institution") String institution);

	@Query("SELECT q FROM Qualification q WHERE q.status like :status")
	List<Qualification> findAllByStatus(@Param("status") String status);
}
