package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Company;

@SpringBootTest
public class CompanyValidatorTest {
    
    private Map<Operation, CompanyValidator> validator;

    @Test
    public void givenAValidCompanyData_whenTryToValidate_thenShouldSuccess() {
        Company company = Company.builder()
                .cnpj("90885568000120")
                .name("A Company Name")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(company));
    }

    @Test
    public void givenAnInvalidCompanyData_whenTryToValidate_thenThrowsException() {
        Company company1 = Company.builder()
                .cnpj("90885568000120")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(company1));

        Company company2 = Company.builder()
                .cnpj("90885568000120")
                .name("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(company2));

        Company company3 = Company.builder()
                .cnpj("123")
                .name("A Company name")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(company3));

        Company company4 = Company.builder()
                .cnpj("")
                .name("Company")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(company4));

        Company company5 = Company.builder()
                .name("Company")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(company5));

    }
    
    @Test
    public void givenAnUpdateInvalidCompanyData_whenTryToValidate_thenThrowsException() {
    	Company company6 = Company.builder()
                .name("Company")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(company6));
		
		Company company7 = Company.builder()
                .name("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(company7));
		
		Company company8 = Company.builder()
				.cnpj("1223344555")
                .name("Company")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(company8));
		
		Company company9 = Company.builder()
                .cnpj("")
				.name("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(company9));
    }
    
    @Test
    public void givenAnDeleteInvalidCompanyData_whenTryToValidate_thenThrowsException() {
    	Company company10 = Company.builder()
                .name("Company")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(company10));
		
		Company company11 = Company.builder()
                .name("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(company11));
		
		Company company12 = Company.builder()
                .cnpj("")
				.name("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(company12));
		
		Company company13 = Company.builder()
                .cnpj("122222222")
				.name("Company")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(company13));
		
		Company company14 = Company.builder()
                .cnpj("")
				.name("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(company14));
    }
}
