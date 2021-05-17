package com.tecnocode.repository;

import com.tecnocode.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    List<Apply> findAllByVacancyId(final Integer id);
}
