package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Benefit;

@SpringBootTest
public class BenefitValidatorTest {

	private Map<Operation, BenefitValidator> validator;

	@Test
	public void givenAValidBenefitData_whenTryToValidate_thenShouldSuccess() {
		Benefit benefit = Benefit.builder()
				.benefit("Vale Refeição")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit));
		
		Benefit benefit1 = Benefit.builder()
				.benefit("Vale Alimentação")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit1));
		
		Benefit benefit2 = Benefit.builder()
				.benefit("Convênio médico")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit2));
		
		Benefit benefit3 = Benefit.builder()
				.benefit("Vale Transporte")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit3));
		
		Benefit benefit4 = Benefit.builder()
				.benefit("Convênio Odontológico")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit4));
		
		Benefit benefit5 = Benefit.builder()
				.benefit("Auxílio Culura")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit5));
		
		Benefit benefit6 = Benefit.builder()
				.benefit("Auxílio Creche")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit6));
		
		Benefit benefit7 = Benefit.builder()
				.benefit("Laboral")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit7));
	}

	@Test
	public void givenAnInvalidBenefitData_whenTryToValidate_thenThrowsException() {
		Benefit benefit8 = Benefit.builder()
				.benefit("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit8));
		
		Benefit benefit9 = Benefit.builder()
				.benefit("Hora extra")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(benefit9));
	}

	@Test
	public void givenAnDeleteInvalidBenefitData_whenTryToValidate_thenThrowsException() {
		Benefit benefit10 = Benefit.builder()
				.benefit("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit10));
		
		Benefit benefit11 = Benefit.builder()
				.benefit("Vale Refeição")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit11));
		
		Benefit benefit12 = Benefit.builder()
				.benefit("Vale Alimentação")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit12));
		
		Benefit benefit13 = Benefit.builder()
				.benefit("Convênio")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit13));
		
		Benefit benefit14 = Benefit.builder()
				.benefit("Convênio odontológico")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit14));
		
		Benefit benefit15 = Benefit.builder()
				.benefit("Vale cultura")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit15));
		
		Benefit benefit16 = Benefit.builder()
				.benefit("Laboral")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit16));
		
		Benefit benefit17 = Benefit.builder()
				.benefit("Auxílio creche")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit17));


		Benefit benefit18 = Benefit.builder()
				.benefit("Inglês")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit18));
		
		Benefit benefit19 = Benefit.builder()
				.benefit("Bonus")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(benefit19));
	}

	@Test
	public void givenAnUpdateInvalidBenefitData_whenTryToValidate_thenThrowsException() {
		Benefit benefit20 = Benefit.builder()
				.benefit("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit20));
	    
		Benefit benefit21 = Benefit.builder()
				.benefit("Vale Refeição")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit21));
		
		Benefit benefit22 = Benefit.builder()
				.benefit("Vale Alimentação")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit22));
		
		Benefit benefit23 = Benefit.builder()
				.benefit("Vale Combustível")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit23));
		
		Benefit benefit24 = Benefit.builder()
				.benefit("Vale Aprendizado")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit24));
		
		Benefit benefit25 = Benefit.builder()
				.benefit("Vale gym")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit25));
		
		Benefit benefit26 = Benefit.builder()
				.benefit("Folga aniversário")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(benefit26));
	}
}