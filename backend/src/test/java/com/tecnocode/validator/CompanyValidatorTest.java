package com.tecnocode.validator;

import com.tecnocode.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CompanyValidatorTest {
    @Autowired
    private CompanyValidator validator;

    @Test
    public void givenAValidCompanyData_whenTryToValidate_thenShouldSuccess() {
        Company company = Company.builder()
                .cnpj("90885568000120")
                .name("A Company Name")
                .build();
        assertDoesNotThrow(() -> validator.validate(company));
    }

    @Test
    public void givenAnInvalidCompanyData_whenTryToValidate_thenThrowsException() {
        Company company1 = Company.builder()
                .cnpj("90885568000120")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(company1));

        Company company2 = Company.builder()
                .cnpj("90885568000120")
                .name("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(company2));

        Company company3 = Company.builder()
                .cnpj("123")
                .name("A Company name")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(company3));

        Company company4 = Company.builder()
                .cnpj("")
                .name("Company")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(company4));

        Company company5 = Company.builder()
                .name("Company")
                .build();
        assertThrows(RuntimeException.class, () -> validator.validate(company5));


    }
}
