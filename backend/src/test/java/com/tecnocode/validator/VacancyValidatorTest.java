package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Address;
import com.tecnocode.model.Company;
import com.tecnocode.model.Vacancy;

@SpringBootTest
public class VacancyValidatorTest {
    
    private Map<Operation, VacancyValidator> validator;

    @Test
    public void givenAValidVacancyData_whenTryToValidate_thenShouldSuccess() {
        Vacancy vacancy = Vacancy.builder()
                .company(Company.builder().id(1).build())
                .address(Address.builder().id(40).build())
                .title("Java Pleno")
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .contract("PJ")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(vacancy));
    }
    @Test
    public void givenAnInvalidVacancyData_whenTryToValidate_thenThrowsException() {
        Vacancy vacancy1 = Vacancy.builder()
                .title("")
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(vacancy1));

        Vacancy vacancy2 = Vacancy.builder()
                .title("")
                .description("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(vacancy2));

        Vacancy vacancy3 = Vacancy.builder()
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(vacancy3));

        Vacancy vacancy4 = Vacancy.builder()
                .title("Java Pleno")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(vacancy4));
    }
    
    @Test
    public void givenAnUpdateInvalidVacancyData_whenTryToValidate_thenThrowsException() {
        Vacancy vacancy5 = Vacancy.builder()
                .title("")
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(vacancy5));
		
		Vacancy vacancy6 = Vacancy.builder()
	                .title("Infra")
	                .description("Neste trabalho será realizado a criação e manutenção de sistemas.")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(vacancy6));
		
		Vacancy vacancy7 = Vacancy.builder()
	                .title("")
	                .description("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(vacancy7));
		
		 Vacancy vacancy8 = Vacancy.builder()
	                .title("Suporte")
	                .description("")
	                .build();
			assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(vacancy8));
			 
		Vacancy vacancy9 = Vacancy.builder()
		                .title("Dev Java")
		                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
		                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(vacancy9));
				 
		Vacancy vacancy10 = Vacancy.builder()
			                .title("Testador")
			                .description("Teste de sistemas")
			                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(vacancy10));
			
    }
    
    @Test
    public void givenAnDeleteInvalidVacancyData_whenTryToValidate_thenThrowsException() {
        Vacancy vacancy11 = Vacancy.builder()
                .title("")
                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(vacancy11));
	
		 Vacancy vacancy12 = Vacancy.builder()
	                .title("")
	                .description("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(vacancy12));
		
		Vacancy vacancy13 = Vacancy.builder()
	                .title("Java")
	                .description("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(vacancy13));
		
		Vacancy vacancy14 = Vacancy.builder()
	                .title("")
	                .description("Teste de sistemas")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(vacancy14));
		
	    Vacancy vacancy15 = Vacancy.builder()
	                .title("Dev java")
	                .description("Neste trabalho será realizado a criação e manutenção de sistemas em Java.")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(vacancy15));
			
    }
}
