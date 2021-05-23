package com.tecnocode.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Skill;
import com.tecnocode.validator.Operation;

@SpringBootTest
public class SkillServiceTest {
	
	 @Autowired
	    private SkillService service;

	    @Test
	    public void givenSkill_WhenTryToSaveANewSkill_thenShouldSuccess() {
	        Skill skill = Skill.builder()
	        		.id(1)
	        		.name("Comunicação")
	        		.level("avançado")
	        		.others("não")
	                .build();
	        final Skill savedSkill = service.save(skill, Operation.INSERT);
	                assertNotNull(savedSkill);
	                assertNotNull(savedSkill.getId());

	        
	    }

}
