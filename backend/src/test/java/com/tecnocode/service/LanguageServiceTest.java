package com.tecnocode.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Language;
import com.tecnocode.validator.Operation;
@SpringBootTest


public class LanguageServiceTest {

	 @Autowired
	    private LanguageService service;

	    @Test
	    public void givenLanguage_WhenTryToSaveANewLanguage_thenShouldSuccess() {
	        Language language = Language.builder()
	                .name("ingles")
	                .level("avancado")
	                .build();
	        final Language savedLanguage = service.save(language, Operation.INSERT);
	        assertAll(() -> {
	                assertNotNull(savedLanguage);
	                assertNotNull(savedLanguage.getId());
	           
	        });
	    }
}
