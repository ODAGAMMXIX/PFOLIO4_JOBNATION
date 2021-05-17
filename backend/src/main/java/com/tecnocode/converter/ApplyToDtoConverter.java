package com.tecnocode.converter;

import com.tecnocode.model.Apply;
import com.tecnocode.payload.ApplyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApplyToDtoConverter implements Converter<Apply, ApplyDTO> {
    @Override
    public ApplyDTO convert(Apply apply){
        return ApplyDTO.builder()
                .vacancyId(apply.getVacancy().getId())
                .candidateId(apply.getCandidate().getId())
                .build();
    }
}
