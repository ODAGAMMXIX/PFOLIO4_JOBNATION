package com.tecnocode.service;

import java.util.List;

import com.tecnocode.model.Language;

public interface LanguageService extends GenericService<Language> {
	List<Language> buscarTodosComEstaLinguagem(final String name);

	List<Language> buscarTodosComEsteNivel(final String level);
}
