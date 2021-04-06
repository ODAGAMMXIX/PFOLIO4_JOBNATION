package com.tecnocode.converter;

import com.tecnocode.model.Vacancy;
import com.tecnocode.payload.VacancyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VacancyToDtoConverter implements Converter<Vacancy, VacancyDTO> {
    @Override
    public VacancyDTO convert(Vacancy vacancy){
        return VacancyDTO.builder()
                .company(vacancy.getCompany())
                .address(vacancy.getAddress())
                .title(vacancy.getTitle())
                .description(vacancy.getDescription())
                .minSalary(vacancy.getMinSalary())
                .maxSalary(vacancy.getMaxSalary())
                .openDate(vacancy.getOpenDate())
                .closeDate(vacancy.getCloseDate())
                .experiences(vacancy.getExperiences())
                .qualifications(vacancy.getQualifications())
                .skills(vacancy.getSkills())
                .languages(vacancy.getLanguages())
                .contract(vacancy.getContract())
                .benefits(vacancy.getBenefits())
                .build();
    }
}
