package com.tecnocode.validator;

import com.tecnocode.model.Qualification;
import org.springframework.stereotype.Component;

@Component
public class QualificationValidator implements AbstractValidator<Qualification> {
    @Override
    public void validate(Qualification qualification){
        if(qualification.getName().isEmpty()){
            throw new RuntimeException("O nome não pode estar vazio.");
        }
        if(qualification.getLevel().isEmpty()){
            throw new RuntimeException("O nível da qualificação não pode estar vazio.");
        }
        if(qualification.getInstitution().isEmpty()){
            throw new RuntimeException("O nome da instituição não pode estar vazio.");
        }
        if(qualification.getStatus().isEmpty()){
            throw new RuntimeException("O status da qualificação não pode estar vazio.");
        }
    }
}
