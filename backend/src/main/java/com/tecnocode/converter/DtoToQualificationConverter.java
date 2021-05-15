package com.tecnocode.converter;

import com.tecnocode.model.Qualification;
import com.tecnocode.payload.QualificationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToQualificationConverter implements Converter<QualificationDTO, Qualification> {
    @Override
    public Qualification convert(QualificationDTO qualificationDTO){
        return Qualification.builder()
                .name(qualificationDTO.getName())
                .level(qualificationDTO.getLevel())
                .institution(qualificationDTO.getInstitution())
                .status(qualificationDTO.getStatus())
                .build();
    }
}
