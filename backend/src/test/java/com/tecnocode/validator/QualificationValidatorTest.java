package com.tecnocode.validator;

import com.tecnocode.model.Qualification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

@SpringBootTest
public class QualificationValidatorTest {
   
    private Map<Operation, QualificationValidator> validator;

    @Test
    public void givenAValidQualificationData_whenTryToValidate_thenShouldSuccess() {
        Qualification qualification = Qualification.builder()
                .name("Professor de Ingles")
                .level("Intermediario - Ensino medio")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(qualification));
    }

    @Test
    public void givenAnInvalidQualificationData_whenTryToValidate_thenThrowsException() {
        Qualification qualification1 = Qualification.builder()
                .name("")
                .level("Intermediario - Ensino medio")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(qualification1));

        Qualification qualification2 = Qualification.builder()
                .name("")
                .level("")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(qualification2));

        Qualification qualification3 = Qualification.builder()
                .name("")
                .level("")
                .institution("")
                .status("Meu trabalho atual")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(qualification3));

        Qualification qualification4 = Qualification.builder()
                .name("")
                .level("")
                .institution("")
                .status("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(qualification4));

        Qualification qualification5 = Qualification.builder()
                .level("Intermediario - Ensino Medio")
                .institution("ETEC - SJC")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(qualification5));
    }
    
    @Test
    public void givenAnUpdateInvalidQualificationData_whenTryToValidate_thenThrowsException() {
        Qualification qualification6 = Qualification.builder()
                .name("")
                .level("Intermediario - Ensino medio")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
	assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(qualification6));
		
    Qualification qualification7 = Qualification.builder()
	                .name("")
	                .level("")
	                .institution("ETEC - SJC")
	                .status("Meu trabalho atual")
	                .build();
	assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(qualification7));
			
	Qualification qualification8 = Qualification.builder()
		                .name("")
		                .level("")
		                .institution("")
		                .status("Meu trabalho atual")
		                .build();
	assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(qualification8));
				
	Qualification qualification9 = Qualification.builder()
			                .name("")
			                .level("")
			                .institution("ETEC - SJC")
			                .status("")
			                .build();
	assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(qualification9));
					
	Qualification qualification10 = Qualification.builder()
				                .name("")
				                .level("")
				                .institution("")
				                .status("")
				                .build();
	assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(qualification10));
		
    }
    
    @Test
    public void givenAnDeleteInvalidQualificationData_whenTryToValidate_thenThrowsException() {
        Qualification qualification11 = Qualification.builder()
                .name("")
                .level("Intermediario - Ensino medio")
                .institution("ETEC - SJC")
                .status("Meu trabalho atual")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(qualification11));
		
		 Qualification qualification12 = Qualification.builder()
	                .name("")
	                .level("")
	                .institution("ETEC - SJC")
	                .status("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(qualification12));
		
		Qualification qualification13 = Qualification.builder()
	                .name("")
	                .level("")
	                .institution("")
	                .status("Meu Trabalho atual")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(qualification13));
		
		 Qualification qualification14 = Qualification.builder()
	                .name("")
	                .level("Intermediario = Ensino medio")
	                .institution("")
	                .status("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(qualification14));
		
		 Qualification qualification15 = Qualification.builder()
	                .name("")
	                .level("")
	                .institution("")
	                .status("")
	                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(qualification15));
    }
}
