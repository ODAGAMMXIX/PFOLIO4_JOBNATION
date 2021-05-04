package com.tecnocode.repository;

import com.tecnocode.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    @Query("SELECT s FROM Skill s WHERE s.name like :name ")
    List<Skill> findAllBySkillName(@Param("name") String name);

    @Query("SELECT s FROM Skill s WHERE s.level like :level ")
    List<Skill> findAllBySkillLevel(@Param("level") String level);
}