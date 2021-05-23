package com.tecnocode.validator;

import org.springframework.stereotype.Component;

import com.tecnocode.model.Benefit;


@Component
public class BenefitValidator implements AbstractValidator<Benefit> {
    @Override
    public void validate(Benefit benefit){
        if(benefit.getBenefit().isEmpty()){
            throw new RuntimeException("O beneficio não pode ser vazio.");
        }
    }

}