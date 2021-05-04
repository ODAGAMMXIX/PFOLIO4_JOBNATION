package com.tecnocode.validator;

import com.tecnocode.model.Experience;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ExperienceValidatorTest {
	@Autowired
	private ExperienceValidator validator;

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
		assertDoesNotThrow(() -> validator.validate(experience));
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
		assertThrows(RuntimeException.class, () -> validator.validate(experience1));

		Experience experience2 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("Executive Manager")
				.achiev("I was a manager for a year at that company.")
				.build();
		 assertThrows(RuntimeException.class, () -> validator.validate(experience2));

		Experience experience3 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("I was a manager for a year at that company.")
				.build();
		 assertThrows(RuntimeException.class, () -> validator.validate(experience3));

		Experience experience4 = Experience.builder()
				.company("")
				.city("")
				.start(start)
				.end(end)
				.title("")
				.achiev("")
				.build();
		 assertThrows(RuntimeException.class, () -> validator.validate(experience4));
	}
}
