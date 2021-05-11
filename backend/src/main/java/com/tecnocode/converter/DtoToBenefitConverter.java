package com.tecnocode.converter;

import com.tecnocode.model.Benefit;
import com.tecnocode.payload.BenefitDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToBenefitConverter implements Converter<BenefitDTO, Benefit>{
    @Override
    public Benefit convert(BenefitDTO benefitDTO){
        return Benefit.builder()
                .benefit(benefitDTO.getBenefit())
                .build();
    }
}
