package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Language;

@SpringBootTest
public class LanguageValidatorTest {

	private Map<Operation, LanguageValidator> validator;

	@Test
	public void givenAValidLanguageData_whenTryToValidate_thenShouldSuccess() {
		Language language = Language.builder()
				.name("Spanish").
				level("Basic")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language));
	}

	@Test
	public void givenAnInvalidLanguageData_whenTryToValidate_thenThrowsException() {
		Language language1 = Language.builder()
				.name("")
				.level("Basic")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language1));

		Language language2 = Language.builder()
				.name("Spanish")
				.level("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language2));

		Language language3 = Language.builder()
				.name("")
				.level("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language3));

		Language language4 = Language.builder()
				.level("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language4));

		Language language5 = Language.builder()
				.name("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language5));
		
		Language language6 = Language.builder()
				.name("Britânio")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language6));
		
		Language language7 = Language.builder()
				.name("Libra")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language7));
		
		Language language8 = Language.builder()
				.name("Russo")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language8));
		
		Language language9 = Language.builder()
				.name("Castelhano")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language9));
		
		Language language10 = Language.builder()
				.name("Alemão")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language10));
		
		Language language11 = Language.builder()
				.name("Francês")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language11));
		
		Language language12 = Language.builder()
				.name("")
				.level("Avançado")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language12));
		
		Language language13 = Language.builder()
				.name("")
				.level("Easy")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language13));
		
		Language language14 = Language.builder()
				.name("")
				.level("Expert")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(language14));

	}

	@Test
	public void givenAnUpdateInvalidLanguageData_whenTryToValidate_thenThrowsException() {
		Language language15 = Language.builder()
				.name("").
				level("Basic").
				build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(language15));
		
		Language language16 = Language.builder()
				.name("").
				level("Hard").
				build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(language16));
		
		Language language17 = Language.builder()
				.name("Spanish").
				level("").
				build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(language17));
		
		Language language18 = Language.builder()
				.name("Alemão").
				level("AVançado").
				build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(language18));
		
		Language language19 = Language.builder()
				.name("Italiano").
				level("Básico").
				build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(language19));
		
		Language language20 = Language.builder()
				.name("Francês").
				level("Fluente").
				build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(language20));
		
	}

	@Test
	public void givenAnDeleteInvalidLanguageData_whenTryToValidate_thenThrowsException() {
		
		Language language21 = Language.builder()
				.name("Inglês")
				.level("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language21));
		
		Language language22 = Language.builder()
				.name("")
				.level("Hard")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language22));
		
		Language language23 = Language.builder()
				.name("Inglês")
				.level("Hard")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language23));
		
		Language language24 = Language.builder()
				.name("Italiano")
				.level("Hard")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language24));
		
		Language language25 = Language.builder()
				.name("Russo")
				.level("Hard")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language25));
		
		Language language26 = Language.builder()
				.name("Indiano")
				.level("Hard")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language26));
		
		Language language27 = Language.builder()
				.name("Português")
				.level("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language27));
		
		Language language28 = Language.builder()
				.name("")
				.level("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(language28));
	}
}
