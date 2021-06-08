package com.tecnocode.service;

import com.tecnocode.model.Apply;
import java.util.List;
import java.util.Set;

public interface ApplyService  extends GenericService<Apply>{
    List<Apply> buscarTodos();

    List<Apply> search(Integer vacancyId, String gender, Set<String> languages, Set<String> qualifications,     Set<String> skills);
    
    Apply saveNewApply(Apply apply, Operation operation)
            throws RuntimeException, IOException, JSONException;
}
