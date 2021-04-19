package com.tecnocode.validator;

import com.tecnocode.model.Qualification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class QualificationValidatorTest {
    @Autowired
    private QualificationValidator validator;

    @Test
    public void givenAValidQualificationData_whenTryToValidate_thenShouldSuccess() {
        Qualification qualification = Qualification.builder()
                .name("Professor de Ingles")
                .level("Intermediario - Ensino medio")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
        assertDoesNotThrow(() -> validator.validate(qualification));
    }

    @Test
    public void givenAnInvalidQualificationData_whenTryToValidate_thenThrowsException() {
        Qualification qualification1 = Qualification.builder()
                .name("")
                .level("Intermediario - Ensino medio")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(qualification1));

        Qualification qualification2 = Qualification.builder()
                .name("")
                .level("")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(qualification2));

        Qualification qualification3 = Qualification.builder()
                .name("")
                .level("")
                .institution("")
                .status("Meu trabalho atual")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(qualification3));

        Qualification qualification4 = Qualification.builder()
                .name("")
                .level("")
                .institution("")
                .status("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(qualification4));

        Qualification qualification5 = Qualification.builder()
                .level("Intermediario - Ensino Medio")
                .institution("ETEC - SJC")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(qualification5));
    }
}
