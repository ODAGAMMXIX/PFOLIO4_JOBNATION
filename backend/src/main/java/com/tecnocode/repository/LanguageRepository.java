package com.tecnocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnocode.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
