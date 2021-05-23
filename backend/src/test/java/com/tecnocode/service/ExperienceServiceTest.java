package com.tecnocode.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Experience;
import com.tecnocode.validator.Operation;

@SpringBootTest
public class ExperienceServiceTest {
	@Autowired
	private ExperienceService service;

	@Test
	public void givenExperience_WhenTryToSaveANewExperience_thenShouldSuccess() {
		DateTimeFormatter date= DateTimeFormatter.ofPattern("dd/MM/uuuu");
		LocalDate start = LocalDate.parse("15/03/1996", date);
		LocalDate end = LocalDate.parse("15/03/2004", date);
		Experience experience = Experience.builder()
				.id(1)
				.company("Buser")
				.city("SJC")
				.start(start)
				.end(end)
				.title("Analista")
				.achiev("1 ano")
				.build();
		final Experience savedExperience = service.save(experience, Operation.INSERT);
		assertNotNull(savedExperience);
		assertNotNull(savedExperience.getId());

	}

}
