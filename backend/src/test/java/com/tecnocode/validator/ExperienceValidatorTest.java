package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Experience;

@SpringBootTest
public class ExperienceValidatorTest {

	private Map<Operation, ExperienceValidator> validator;

	@Test
	public void givenAValidExperienceData_whenTryToValidate_thenShouldSuccess() {
		DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate start = LocalDate.parse("15/03/1996", date);
		LocalDate end = LocalDate.parse("15/03/2004", date);
		Experience experience = Experience.builder()
				.company("Microsoft")
				.city("Los Angeles")
				.start(start)
				.end(end)
				.title("Executive Manager")
				.achiev("I was a manager for a year at that company.")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(experience));
	}

	@Test
	public void givenAnInvalidExperienceData_whenTryToValidate_thenThrowsException() {
		DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate start = LocalDate.parse("15/03/1996", date);
		LocalDate end = LocalDate.parse("15/03/2004", date);
		Experience experience1 = Experience.builder()
				.company("")
				.city("Los Angeles")
				.start(start)
				.end(end)
				.title("Executive Manager")
				.achiev("I was a manager for a year at that company.")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(experience1));

		Experience experience2 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("Executive Manager")
				.achiev("I was a manager for a year at that company.")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(experience2));

		Experience experience3 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("I was a manager for a year at that company.")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(experience3));

		Experience experience4 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(experience4));
	}
	
	@Test
	public void givenAnUpdateInvalidExperienceData_whenTryToValidate_thenThrowsException() {
		DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate start = LocalDate.parse("15/03/1996", date);
		LocalDate end = LocalDate.parse("15/03/2004", date);
		Experience experience5 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(experience5));
		
		Experience experience6 = Experience.builder()
				.company("Company")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(experience6));
		
		Experience experience7 = Experience.builder()
				.company("")
				.city("São Paulo")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(experience7));
		
		Experience experience8 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("Manager")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(experience8));
		
		Experience experience9 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("I was a manager for a year at that company.")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(experience9));
		
		Experience experience10 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(experience10));
	}
	
	@Test
	public void givenAnDeleteInvalidExperienceData_whenTryToValidate_thenThrowsException() {
		DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate start = LocalDate.parse("15/03/1996", date);
		LocalDate end = LocalDate.parse("15/03/2004", date);
		Experience experience11 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience11));
		
		Experience experience12 = Experience.builder()
				.company("Company2")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience12));
		
		Experience experience13 = Experience.builder()
				.company("")
				.city("SJC")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience13));
		
		Experience experience14 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("Tester")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience14));
		
		Experience experience15 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("I was a manager for a year at that company")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience15));
		
		Experience experience16 = Experience.builder()
				.company("company3")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience16));
		
		Experience experience17 = Experience.builder()
				.company("Fitec")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience17));
		
		Experience experience18 = Experience.builder()
				.company("FATEC")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience18));
		
		Experience experience19 = Experience.builder()
				.company("IPPLAN")
				.city("SJC")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience19));
		
		Experience experience20 = Experience.builder()
				.company("Saipher")
				.city("")
				.start(start)
				.end(end)
				.title("Teste")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience20));
		
		Experience experience21 = Experience.builder()
				.company("IACIT")
				.city("SJC")
				.start(start)
				.end(end)
				.title("Programador")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience21));
		
		Experience experience22 = Experience.builder()
				.company("Zappits")
				.city("SP")
				.start(start)
				.end(end)
				.title("Analista de qualidade")
				.achiev("")
				.build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(experience22));
    }
	
}