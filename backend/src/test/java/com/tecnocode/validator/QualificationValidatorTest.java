package com.tecnocode.validator;

import com.tecnocode.model.Benefit;
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
    public void givenAValidCompanyData_whenTryToValidate_thenShouldSuccess() {
        Qualification qualification = Qualification.builder()
                .name("Vale Refeição")
                .build();
        assertDoesNotThrow(() -> validator.validate(qualification));
    }

    @Test
    public void givenAnInvalidCompanyData_whenTryToValidate_thenThrowsException() {
        Qualification qualification1 = Qualification.builder()
                .name("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(qualification1));
    }
}
