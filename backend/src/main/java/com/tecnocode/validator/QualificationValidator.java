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
    }
}
