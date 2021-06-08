package com.tecnocode.validator;

import com.tecnocode.model.Address;
import com.tecnocode.model.Company;
import com.tecnocode.model.Vacancy;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
@Ignore
@SpringBootTest
public class VacancyValidatorTest {
    @Autowired
    private VacancyValidator validator;

    @Test
    public void givenAValidVacancyData_whenTryToValidate_thenShouldSuccess() {
        Vacancy vacancy = Vacancy.builder()
                .company(Company.builder().id(1).build())
                .address(Address.builder().id(40).build())
                .title("Java Pleno")
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .contract("PJ")
                .build();
        assertDoesNotThrow(() -> validator.validate(vacancy));
    }
    @Test
    public void givenAnInvalidVacancyData_whenTryToValidate_thenThrowsException() {
        Vacancy vacancy1 = Vacancy.builder()
                .title("")
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(vacancy1));

        Vacancy vacancy2 = Vacancy.builder()
                .title("")
                .description("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(vacancy2));

        Vacancy vacancy3 = Vacancy.builder()
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(vacancy3));

        Vacancy vacancy4 = Vacancy.builder()
                .title("Java Pleno")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(vacancy4));
    }
}
