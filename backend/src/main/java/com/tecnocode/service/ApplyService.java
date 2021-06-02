package com.tecnocode.service;

import com.tecnocode.model.Apply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ApplyService  extends GenericService<Apply>{

    List<Apply> buscarTodos();

    @Query("SELECT a FROM Apply a WHERE a.candidate.gender = :gender AND a.candidate.languages in (:languages)" +
            "AND a.candidate.qualifications = (:qualifications) AND a.candidate.skills = (:skills)")
    List<Apply> search(@Param("gender") String gender, @Param("languages") Set<String> languages,
                       @Param("qualifications") Set<String> qualifications, @Param("skills") Set<String> skills);
}
