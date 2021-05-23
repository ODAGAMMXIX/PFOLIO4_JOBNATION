package com.tecnocode.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Qualification;
import com.tecnocode.validator.Operation;

@SpringBootTest
public class QualificationServiceTest {
	@Autowired
	private QualificationService service;

	@Test
	public void givenQualification_WhenTryToSaveANewQualification_thenShouldSuccess() {
		Qualification qualification = Qualification.builder()
				.id(1)
				.name("Banco de dados")
				.level("Superior")
				.institution("Fatec")
				.status("Concluído")
				.build();
		final Qualification savedQualification = service.save(qualification, Operation.INSERT);
		assertNotNull(savedQualification);
		assertNotNull(savedQualification.getId());

	}

}
