package com.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.tecnocode.model.Language;
import com.tecnocode.payload.LanguageDTO;

@Component
public class LanguageToDtoConverter implements Converter<Language, LanguageDTO> {
	@Override
	public LanguageDTO convert(Language language) {
		return LanguageDTO.builder()
				.name(language.getName())
				.level(language.getLevel())
				.build();
	}
}
