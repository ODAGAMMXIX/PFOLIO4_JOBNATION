package com.tecnocode.repository;

import com.tecnocode.model.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
    @Query("SELECT b FROM Benefit b WHERE b.benefit like :benefit ")
    List<Benefit> findAllByBenefit(@Param("benefit") String benefit);
}
