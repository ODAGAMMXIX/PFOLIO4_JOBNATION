package com.tecnocode.converter;

import com.tecnocode.model.Apply;
import com.tecnocode.payload.ApplyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToApplyConverter implements Converter<ApplyDTO, Apply>  {
    @Override
    public Apply convert(ApplyDTO applyDTO){
        return Apply.builder()
                .vacancy(applyDTO.getVacancy())
                .candidate(applyDTO.getCandidate())
                .build();
    }
}
