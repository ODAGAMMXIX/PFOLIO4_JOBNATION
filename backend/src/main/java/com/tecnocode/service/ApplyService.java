package com.tecnocode.service;

import com.tecnocode.model.Address;
import com.tecnocode.model.Apply;
import java.util.List;

public interface ApplyService  extends GenericService<Apply>{

    List<Apply> buscarTodos();
}
