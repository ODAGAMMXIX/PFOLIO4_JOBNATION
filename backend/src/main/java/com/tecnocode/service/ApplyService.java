package com.tecnocode.service;

import com.tecnocode.model.Apply;
import java.util.List;

public interface ApplyService  extends GenericService<Apply>{
    List<Apply> buscarTodosComEsteEndereco(final Boolean vacancy);

    List<Apply> buscarTodosComEstaCompanhia(final Boolean candidate);
}
