package com.tecnocode.validator;

import com.tecnocode.model.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

@SpringBootTest
public class SkillValidatorTest {

    
    private Map<Operation, SkillValidator> validator;

    @Test
    public void givenAValidSkillData_whenTryToValidate_thenShouldSuccess() {
        Skill skill = Skill.builder()
                .name("Curso de Java no Alura")
                .level("Iniciante")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(skill));
    }

    @Test
    public void givenAnInvalidSkillData_whenTryToValidate_thenThrowsException() {
        Skill skill1 = Skill.builder()
                .name("")
                .level("Iniciante")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(skill1));

        Skill skill2 = Skill.builder()
                .name("")
                .level("")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(skill2));

        Skill skill3 = Skill.builder()
                .name("")
                .level("")
                .others("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(skill3));

        Skill skill4 = Skill.builder()
                .name("")
                .others("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(skill4));
    }
    
    @Test
    public void givenAnUpdateInvalidSkillData_whenTryToValidate_thenThrowsException() {
        Skill skill5 = Skill.builder()
                .name("")
                .level("Iniciante")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(skill5));
		
	    Skill skill6 = Skill.builder()
	                .name("")
	                .level("Iniciante")
	                .others("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(skill6));
			
	    Skill skill7 = Skill.builder()
		                .name("")
		                .level("")
		                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
		                .build();
	    assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(skill7));	
	    
	    Skill skill8 = Skill.builder()
	                .name("Banco de Dados")
	                .level("Iniciante")
	                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(skill8));
		
	     Skill skill9 = Skill.builder()
	                .name("")
	                .level("")
	                .others("")
	                .build();
			assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(skill9));
    }
    
    @Test
    public void givenAnDeleteInvalidSkillData_whenTryToValidate_thenThrowsException() {
        Skill skill10 = Skill.builder()
                .name("")
                .level("Iniciante")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(skill10));
		
		Skill skill11 = Skill.builder()
	                .name("")
	                .level("")
	                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(skill11));
		
		Skill skill12 = Skill.builder()
	                .name("")
	                .level("Iniciante")
	                .others("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(skill12));
		
		Skill skill13 = Skill.builder()
	                .name("Programação")
	                .level("Iniciante")
	                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(skill13));
		
		Skill skill14 = Skill.builder()
	                .name("")
	                .level("")
	                .others("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(skill14));
    }
}
