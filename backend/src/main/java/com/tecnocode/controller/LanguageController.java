package com.tecnocode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tecnocode.converter.DtoToLanguageConverter;
import com.tecnocode.converter.LanguageToDtoConverter;
import com.tecnocode.model.Language;
import com.tecnocode.payload.LanguageDTO;
import com.tecnocode.service.LanguageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
	private final LanguageService service;
	private final DtoToLanguageConverter dtoToLanguageConverter;
	private final LanguageToDtoConverter languageToDtoConverter;

	@PostMapping
	public ResponseEntity saveNew(final LanguageDTO languageDTO) {
		try {
			Language language = service.save(dtoToLanguageConverter.convert(languageDTO));
			return ResponseEntity.status(HttpStatus.CREATED).body(languageToDtoConverter.convert(language));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}
}
