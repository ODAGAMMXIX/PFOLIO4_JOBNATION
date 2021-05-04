package com.tecnocode.repository;

import com.tecnocode.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer>{
	@Query("SELECT e FROM Experience e WHERE e.company like :company")
	List<Experience> findAllByCompany(@Param("company") String company);
	
	@Query("SELECT e FROM Experience e WHERE e.city like :city")
	List<Experience> findAllByCity(@Param("city") String city);
	
	@Query("SELECT e FROM Experience e WHERE e.start <= :start AND e.start IS NOT NULL")
	List<Experience> findAllByInit(@Param("start") LocalDate start);
	
	@Query("SELECT e FROM Experience e WHERE e.end <= :end AND e.end IS NOT NULL")
	List<Experience> findAllByFinish(@Param("end") LocalDate end);
	
	@Query("SELECT e FROM Experience e WHERE e.title like :title")
	List<Experience> findAllByTitle(@Param("title") String title);
	
	@Query("SELECT e FROM Experience e WHERE e.achiev like :achiev")
	List<Experience> findAllByAchiev(@Param("achiev") String achiev);
} 
