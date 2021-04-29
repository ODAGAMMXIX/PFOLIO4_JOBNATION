package com.tecnocode.service.impl;

import com.tecnocode.validator.Operation;
import org.springframework.stereotype.Service;
import com.tecnocode.model.Language;
import com.tecnocode.repository.LanguageRepository;
import com.tecnocode.service.LanguageService;
import com.tecnocode.validator.LanguageValidator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
	private final LanguageRepository repository;
	private final LanguageValidator validator;

	@Override
	public Language save(final Language language, Operation operation) {
		validator.validate(language);
		return repository.saveAndFlush(language);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Language> buscarTodosComEstaLinguagem(String name) {
		return repository.findAllByName(name);
	}

	@Override
	public List<Language> buscarTodosComEsteNivel(String level) {
		return repository.findAllByLevel(level);
	}

}
