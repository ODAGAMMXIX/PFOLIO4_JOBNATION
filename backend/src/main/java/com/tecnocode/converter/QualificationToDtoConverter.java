package com.tecnocode.converter;

import com.tecnocode.model.Qualification;
import org.springframework.core.convert.converter.Converter;
import com.tecnocode.payload.QualificationDTO;
import org.springframework.stereotype.Component;

@Component
public class QualificationToDtoConverter implements Converter<Qualification, QualificationDTO> {

    @Override
    public QualificationDTO convert(Qualification qualification){
        return QualificationDTO.builder()
                .name(qualification.getName())
                .level(qualification.getLevel())
                .institution(qualification.getInstitution())
                .couse(qualification.getCouse())
                .start(qualification.getStart())
                .end(qualification.getEnd())
                .status(qualification.getStatus())
                .build();
    }
}
