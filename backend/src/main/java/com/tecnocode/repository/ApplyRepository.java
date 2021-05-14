package com.tecnocode.repository;

import com.tecnocode.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    @Query("SELECT a FROM Apply a WHERE a.vacancy like :vacancy")
    List<Apply> findAllByVacancyApply(@Param("vacancy") Boolean vacancy);

    @Query("SELECT a FROM Apply a WHERE a.candidate like :candidate")
    List<Apply> findAllByCandidateApply(@Param("candidate") Boolean candidate);
}
