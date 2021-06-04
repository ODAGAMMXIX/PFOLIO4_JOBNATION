package com.tecnocode.service;

import com.tecnocode.model.Apply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ApplyService  extends GenericService<Apply>{

    List<Apply> buscarTodos();

    List<Apply> search(Integer vacancyId, String gender, Set<String> languages, Set<String> qualifications, Set<String> skills);
}
