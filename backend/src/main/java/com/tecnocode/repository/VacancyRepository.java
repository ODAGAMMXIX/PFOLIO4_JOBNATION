package com.tecnocode.repository;

import com.tecnocode.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer>{
}
