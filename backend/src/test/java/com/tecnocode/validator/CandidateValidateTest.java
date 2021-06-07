package com.tecnocode.validator;

import com.tecnocode.model.Candidate;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class CandidateValidateTest {
    @Autowired
    private CandidateValidator validator;

    @Ignore
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
        assertDoesNotThrow(() -> validator.validate(candidate));
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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate1));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate2));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate3));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate4));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate5));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate6));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate7));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate8));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate9));

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
        assertThrows(RuntimeException.class, () -> validator.validate(candidate10));
    }
}
