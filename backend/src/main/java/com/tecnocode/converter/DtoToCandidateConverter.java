package com.tecnocode.converter;

import com.tecnocode.model.*;
import com.tecnocode.payload.CandidateDTO;
import com.tecnocode.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DtoToCandidateConverter implements Converter<CandidateDTO, Candidate> {

    private final ExperienceRepository experienceRepository;
    private final QualificationRepository qualificationRepository;
    private final SkillRepository skillRepository;
    private final LanguageRepository languageRepository;
    private final AddressRepository addressRepository;

    @Override
    public Candidate convert(CandidateDTO candidateDTO){
        return Candidate.builder()
                .address(addressRepository.findById(candidateDTO.getAddressId()).orElse(null))
                .cpf(candidateDTO.getCpf())
                .firstName(candidateDTO.getFirstName())
                .middleName(candidateDTO.getMiddleName())
                .surname(candidateDTO.getSurname())
                .gender(candidateDTO.getGender())
                .marital(candidateDTO.getMarital())
                .birth(candidateDTO.getBirth())
                .marital(candidateDTO.getMarital())
                .email(candidateDTO.getEmail())
                .mobile(candidateDTO.getMobile())
                .phone(candidateDTO.getPhone())
                .experiences(listExperiences(candidateDTO.getExperiences()))
                .qualifications(listQualification(candidateDTO.getQualifications()))
                .skills(listSkills(candidateDTO.getSkills()))
                .languages(listLanguages(candidateDTO.getLanguages()))
                .build();
    }

    private Set<Experience> listExperiences(Set<Integer> ids) {
        return ids.stream()
                .map(experienceRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    private Set<Qualification> listQualification(Set<Integer> ids) {
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
