package com.tecnocode.converter;

import com.tecnocode.model.*;
import com.tecnocode.payload.VacancyDTO;
import com.tecnocode.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DtoToVacancyConverter implements Converter<VacancyDTO, Vacancy> {

    private final ExperienceRepository experienceRepository;
    private final QualificationRepository qualificationRepository;
    private final SkillRepository skillRepository;
    private final LanguageRepository languageRepository;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final BenefitRepository benefitRepository;

    @Override
    public Vacancy convert(VacancyDTO vacancyDTO){
        return Vacancy.builder()
                .company(companyRepository.findById(vacancyDTO.getCompanyId()).orElse(null))
                .address(addressRepository.findById(vacancyDTO.getAddressId()).orElse(null))
                .title(vacancyDTO.getTitle())
                .description(vacancyDTO.getDescription())
                .minSalary(vacancyDTO.getMinSalary())
                .maxSalary(vacancyDTO.getMaxSalary())
                .openDate(vacancyDTO.getOpenDate())
                .closeDate(vacancyDTO.getCloseDate())
                .experiences(listExperiences(vacancyDTO.getExperiences()))
                .qualifications(listQualifications(vacancyDTO.getQualifications()))
                .skills(listSkills(vacancyDTO.getSkills()))
                .languages(listLanguages(vacancyDTO.getLanguages()))
                .contract(vacancyDTO.getContract())
                .benefits(vacancyDTO.getBenefits().stream().map(benefitRepository::findById).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet()))
                .build();
    }

    private Set<Experience> listExperiences(Set<Integer> ids) {
        return ids.stream()
                .map(experienceRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Qualification> listQualifications(Set<Integer> ids) {
        return ids.stream()
                .map(qualificationRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Skill> listSkills(Set<Integer> ids) {
        return ids.stream()
                .map(skillRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Language> listLanguages(Set<Integer> ids) {
        return ids.stream()
                .map(languageRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }
}
