package com.tecnocode.service;

import com.tecnocode.model.Benefit;

import java.util.List;

public interface BenefitService extends GenericService<Benefit>{
    List<Benefit> buscarTodosComEsteBeneficio(final String benefit);
}
