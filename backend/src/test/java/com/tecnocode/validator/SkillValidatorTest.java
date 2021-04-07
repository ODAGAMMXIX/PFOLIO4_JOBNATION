package com.tecnocode.validator;

import com.tecnocode.model.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SkillValidatorTest {

    @Autowired
    private SkillValidator validator;

    @Test
    public void givenAValidSkillData_whenTryToValidate_thenShouldSuccess() {
        Skill skill = Skill.builder()
                .name("Curso de Java no Alura")
                .level("Iniciante")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
        assertDoesNotThrow(() -> validator.validate(skill));
    }

    @Test
    public void givenAnInvalidSkillData_whenTryToValidate_thenThrowsException() {
        Skill skill1 = Skill.builder()
                .name("")
                .level("Iniciante")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(skill1));

        Skill skill2 = Skill.builder()
                .name("")
                .level("")
                .others("Neste curso aprendi a utilizar o JDK, IDE, Spring.")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(skill2));

        Skill skill3 = Skill.builder()
                .name("")
                .level("")
                .others("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(skill3));

        Skill skill4 = Skill.builder()
                .name("")
                .others("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(skill4));
    }
}
