package com.tecnocode.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Candidate;

@SpringBootTest
public class CandidateValidateTest {

	private Map<Operation, CandidateValidator> validator;

    @Test
    public void givenAValidCandidateData_whenTryToValidate_thenShouldSuccess() {
        Candidate candidate = Candidate.builder()
                .cpf("491.884.788-92")
                .firstName("Gabriela")
                .middleName("Silva")
                .surname("Matarazzo")
                .gender("Feminino")
                .marital("solteira")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate));
    }

    @Test
    public void givenAnInvalidCandidateData_whenTryToValidate_thenThrowsException() {
        Candidate candidate1 = Candidate.builder()
                .cpf("")
                .firstName("Gabriela")
                .middleName("Silva")
                .surname("Matarazzo")
                .gender("Feminino")
                .marital("solteira")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate1));

        Candidate candidate2 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("Silva")
                .surname("Matarazzo")
                .gender("Feminino")
                .marital("solteira")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate2));

        Candidate candidate3 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("Matarazzo")
                .gender("Feminino")
                .marital("solteira")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate3));

        Candidate candidate4 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("Feminino")
                .marital("solteira")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate4));

        Candidate candidate5 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("")
                .marital("solteira")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate5));

        Candidate candidate6 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("")
                .marital("")
//                .birth(2001/02/16)
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate6));

        Candidate candidate7 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("")
                .marital("")
//                .birth()
                .email("gabrielasilva@hotmail.com")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate7));

        Candidate candidate8 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("")
                .marital("")
//                .birth()
                .email("")
                .mobile(40028922)
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate8));

        Candidate candidate9 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("")
                .marital("")
//                .birth()
                .email("")
                .phone(988452651)
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate9));

        Candidate candidate10 = Candidate.builder()
                .cpf("")
                .firstName("")
                .middleName("")
                .surname("")
                .gender("")
                .marital("")
//                .birth()
                .email("")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(candidate10));
    }
    
    @Test
    public void givenAnUpdateInvalidCandidateData_whenTryToValidate_thenThrowsException() {
    	 Candidate candidate11 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate11));
 		
 		 Candidate candidate12 = Candidate.builder()
                 .cpf("12345678911")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate12));
 		
 		 Candidate candidate13 = Candidate.builder()
                 .cpf("")
                 .firstName("Juvenal")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate13));
 		
 		 Candidate candidate14 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("Silva")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate14));
 		
 		 Candidate candidate15 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("Sousa")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate15));
 		
 		 Candidate candidate16 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("F")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate16));
 		
 		 Candidate candidate17 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("Single")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate17));
 		
 		 Candidate candidate18 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate18));
 		
		 Candidate candidate19 = Candidate.builder()
                 .cpf("")
                 .firstName("Solange")
                 .middleName("")
                 .surname("Abreu")
                 .gender("Casada")
                 .marital("")
//                 .birth()
                 .email("teste6@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate19));
 		
		 Candidate candidate20 = Candidate.builder()
                 .cpf("12345444444")
                 .firstName("")
                 .middleName("Faria")
                 .surname("Dias")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste9@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate20));
 		
		 Candidate candidate21 = Candidate.builder()
                 .cpf("")
                 .firstName("Lopes")
                 .middleName("Silva")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("email@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate21));
 		
		 Candidate candidate22 = Candidate.builder()
                 .cpf("")
                 .firstName("Gabriel")
                 .middleName("Fernandes")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste9@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate22));
 		
		 Candidate candidate23 = Candidate.builder()
                 .cpf("1223332222")
                 .firstName("Rafael")
                 .middleName("")
                 .surname("Almeida")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste11@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate23));
 		
		 Candidate candidate24 = Candidate.builder()
                 .cpf("")
                 .firstName("Efigênio")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("Divorciado")
//                 .birth()
                 .email("teste@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.UPDATE).validate(candidate24));
    }
    
    @Test
    public void givenAnDeleteInvalidCandidateData_whenTryToValidate_thenThrowsException() {
    	 Candidate candidate25 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate25));
 		
 		 Candidate candidate26 = Candidate.builder()
                 .cpf("12345678911")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate26));
 		
 		 Candidate candidate27 = Candidate.builder()
                 .cpf("")
                 .firstName("Aparecida")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate27));
 		
 		 Candidate candidate28 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("Maria")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate28));
 		
 		 Candidate candidate29 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("Silva")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate29));
 		
 		 Candidate candidate30 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("F")
                 .marital("")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate30));
 		
 		 Candidate candidate31 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("Single")
//                 .birth()
                 .email("")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate31));
 		
 		 Candidate candidate32 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste2@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate32));
 		
 		 Candidate candidate33 = Candidate.builder()
                 .cpf("")
                 .firstName("Francisca")
                 .middleName("")
                 .surname("Leite")
                 .gender("")
                 .marital("Solteira")
//                 .birth()
                 .email("teste2@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate33));
 		

		 Candidate candidate34 = Candidate.builder()
                .cpf("14555555567")
                .firstName("Beatriz")
                .middleName("Cintia")
                .surname("")
                .gender("")
                .marital("")
//                .birth()
                .email("teste2@teste.com")
                .build();
		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate34));
 		
 		 Candidate candidate35 = Candidate.builder()
                 .cpf("14555555567")
                 .firstName("")
                 .middleName("Antonieta")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste2@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate35));
 		
 		 Candidate candidate36 = Candidate.builder()
                 .cpf("")
                 .firstName("Antony")
                 .middleName("Bridgertons")
                 .surname("")
                 .gender("M")
                 .marital("")
//                 .birth()
                 .email("teste2@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate36));
 		
 		 Candidate candidate37 = Candidate.builder()
                 .cpf("")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("M")
                 .marital("Solteira")
//                 .birth()
                 .email("teste2@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate37));
 		
 		 Candidate candidate38 = Candidate.builder()
                 .cpf("1255677788")
                 .firstName("")
                 .middleName("")
                 .surname("")
                 .gender("")
                 .marital("")
//                 .birth()
                 .email("teste2@teste.com")
                 .build();
 		assertThrows(RuntimeException.class, () -> validator.get(Operation.DELETE).validate(candidate38));
    }
}
