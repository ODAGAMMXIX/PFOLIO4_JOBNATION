package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecnocode.model.Language;

@SpringBootTest
public class LanguageValidatorTest {
	@Autowired
	private LanguageValidator validator;
	
	@Test
    public void givenAValidCompanyData_whenTryToValidate_thenShouldSuccess() {
        Language language = Language.builder()
                .name("Spanish")
                .level("Basic")
                .build();
        assertDoesNotThrow(() -> validator.validate(language));
    }

	 @Test
	    public void givenAnInvalidCompanyData_whenTryToValidate_thenThrowsException() {
	        Language language1 = Language.builder()
	                .name("")
	                .level("")
	                .build();
	        assertThrows(RuntimeException.class, () -> validator.validate(language1));
	    }

}
