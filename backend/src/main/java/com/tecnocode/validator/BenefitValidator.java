package com.tecnocode.validator;

import com.tecnocode.model.Benefit;
import org.springframework.stereotype.Component;

@Component
public class BenefitValidator implements AbstractValidator<Benefit> {
    @Override
    public void validate(Benefit benefit){
        if(benefit.getBenefit().isEmpty()){
            throw new RuntimeException("O beneficio não pode ser vazio.");
        }
    }
}
