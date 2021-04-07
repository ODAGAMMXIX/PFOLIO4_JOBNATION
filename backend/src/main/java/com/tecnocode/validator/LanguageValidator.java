package com.tecnocode.validator;

import org.springframework.stereotype.Component;
import com.tecnocode.model.Language;

@Component
public class LanguageValidator implements AbstractValidator<Language> {
	@Override
	public void validate(Language language) {
		if (language.getName().isEmpty()) {
			throw new RuntimeException("O idioma não pode estar ser vazio.");
		}
		if (language.getLevel().isEmpty()) {
			throw new RuntimeException("O idioma da lingua não pode ser vazio.");
		}
	}
}
