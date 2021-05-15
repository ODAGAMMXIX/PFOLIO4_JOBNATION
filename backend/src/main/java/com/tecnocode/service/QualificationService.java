package com.tecnocode.service;

import java.time.LocalDate;
import java.util.List;

import com.tecnocode.model.Qualification;

public interface QualificationService extends GenericService<Qualification> {
	List<Qualification> buscarTodosComEstaQualificacao(final String name);

	List<Qualification> buscarTodosComEsteNivel(final String level);

	List<Qualification> buscarTodosComEstaInstituicao(final String institution);

	List<Qualification> buscarTodosComEsteStatus(final String status);

}
