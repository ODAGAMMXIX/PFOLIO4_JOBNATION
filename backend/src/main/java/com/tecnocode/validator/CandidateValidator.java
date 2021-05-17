package com.tecnocode.validator;

import com.tecnocode.model.Candidate;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class CandidateValidator implements AbstractValidator<Candidate> {
    @Override
    public void validate(Candidate candidate){
        if(candidate.getCpf().isEmpty()){
            throw new RuntimeException("O CPF não pode ser vazio.");
        }
        if(candidate.getFirstName().isEmpty()){
            throw new RuntimeException("O primeiro nome não pode ser vazio.");
        }
        if(candidate.getMiddleName().isEmpty()){
            throw new RuntimeException("O nome do meio não pode ser vazio.");
        }
        if(candidate.getSurname().isEmpty()){
            throw new RuntimeException("O ultimo nome não pode ser vazio.");
        }
        if(candidate.getGender().isEmpty()){
            throw new RuntimeException("O genero não pode ser vazio.");
        }
        if(candidate.getMarital().isEmpty()){
            throw new RuntimeException("O status de relacionamento não pode ser vazio.");
        }
        if(isNull(candidate.getBirth())){
            throw new RuntimeException("O aniversario não pode ser vazio.");
        }
        if(candidate.getEmail().isEmpty()){
            throw new RuntimeException("O email não pode ser vazio.");
        }
        if(isNull(candidate.getMobile())){
            throw new RuntimeException("O número de celular não pode ser vazio.");
        }
    }
}
