package com.tecnocode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tecnocode.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	@Query("SELECT l FROM Language l WHERE l.name like :name")
	List<Language> findAllByName(@Param("name") String name);

	@Query("SELECT l FROM Language l WHERE l .level like :level")
	List<Language> findAllByLevel(@Param("level") String level);

}
