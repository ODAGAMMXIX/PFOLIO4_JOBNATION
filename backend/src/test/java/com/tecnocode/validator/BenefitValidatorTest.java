package com.tecnocode.validator;

import com.tecnocode.model.Benefit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BenefitValidatorTest {
    @Autowired
    private BenefitValidator validator;

    @Test
    public void givenAValidBenefitData_whenTryToValidate_thenShouldSuccess() {
        Benefit benefit = Benefit.builder()
                .benefit("Vale Refeição")
                .build();
        assertDoesNotThrow(() -> validator.validate(benefit));
    }

    @Test
    public void givenAnInvalidBenefitData_whenTryToValidate_thenThrowsException() {
        Benefit benefit1 = Benefit.builder()
                .benefit("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(benefit1));
    }
}
