package com.tecnocode.converter;

import com.tecnocode.model.Vacancy;
import com.tecnocode.payload.VacancyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToVacancyConverter implements Converter<VacancyDTO, Vacancy> {
    @Override
    public Vacancy convert(VacancyDTO vacancyDTO){
        return Vacancy.builder()
                .company(vacancyDTO.getCompany())
                .address(vacancyDTO.getAddress())
                .title(vacancyDTO.getTitle())
                .description(vacancyDTO.getDescription())
                .minSalary(vacancyDTO.getMinSalary())
                .maxSalary(vacancyDTO.getMaxSalary())
                .openDate(vacancyDTO.getOpenDate())
                .closeDate(vacancyDTO.getCloseDate())
                .experiences(vacancyDTO.getExperiences())
                .qualifications(vacancyDTO.getQualifications())
                .skills(vacancyDTO.getSkills())
                .languages(vacancyDTO.getLanguages())
                .contract(vacancyDTO.getContract())
                .benefits(vacancyDTO.getBenefits())
                .build();
    }
}
