package com.tecnocode.converter;

import com.tecnocode.model.*;
import com.tecnocode.payload.VacancyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VacancyToDtoConverter implements Converter<Vacancy, VacancyDTO> {
    @Override
    public VacancyDTO convert(Vacancy vacancy){
        return VacancyDTO.builder()
                .companyId(vacancy.getCompany().getId())
                .addressId(vacancy.getAddress().getId())
                .title(vacancy.getTitle())
                .description(vacancy.getDescription())
                .minSalary(vacancy.getMinSalary())
                .maxSalary(vacancy.getMaxSalary())
                .openDate(vacancy.getOpenDate())
                .closeDate(vacancy.getCloseDate())
                .experiences(vacancy.getExperiences().stream().map(Experience::getId).collect(Collectors.toSet()))
                .qualifications(vacancy.getQualifications().stream().map(Qualification::getId).collect(Collectors.toSet()))
                .skills(vacancy.getSkills().stream().map(Skill::getId).collect(Collectors.toSet()))
                .languages(vacancy.getLanguages().stream().map(Language::getId).collect(Collectors.toSet()))
                .contract(vacancy.getContract())
                .benefits(vacancy.getBenefits().stream().map(Benefit::getId).collect(Collectors.toSet()))
                .build();
    }
}
