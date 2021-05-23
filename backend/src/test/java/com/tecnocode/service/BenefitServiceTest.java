package com.tecnocode.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Benefit;
import com.tecnocode.validator.Operation;

@SpringBootTest
public class BenefitServiceTest {

	 @Autowired
	    private BenefitService service;

	    @Test
	    public void givenBenefit_WhenTryToSaveANewBenefit_thenShouldSuccess() {
	        Benefit benefit = Benefit.builder()
	        		.id(1)
	        		.benefit("Convênio Médico")
	                .build();
	        final Benefit savedBenefit = service.save(benefit, Operation.INSERT);
	                assertNotNull(savedBenefit);
	                assertNotNull(savedBenefit.getId());

	        
	    }
}
