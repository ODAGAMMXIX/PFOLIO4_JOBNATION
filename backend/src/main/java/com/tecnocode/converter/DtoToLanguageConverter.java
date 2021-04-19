package com.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.tecnocode.model.Language;
import com.tecnocode.payload.LanguageDTO;

@Component
public class DtoToLanguageConverter implements Converter<LanguageDTO, Language> {
	@Override
	public Language convert(LanguageDTO languageDTO) {
		return Language.builder()
				.name(languageDTO.getName())
				.level(languageDTO.getLevel())
				.build();
	 }
}
