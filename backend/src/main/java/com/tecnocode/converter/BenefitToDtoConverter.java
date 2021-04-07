package com.tecnocode.converter;

import com.tecnocode.model.Benefit;
import com.tecnocode.payload.BenefitDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BenefitToDtoConverter implements Converter<Benefit, BenefitDTO> {
    @Override
    public BenefitDTO convert(Benefit benefit){
        return BenefitDTO.builder()
                .benefit(benefit.getBenefit())
                .build();
    }
}
