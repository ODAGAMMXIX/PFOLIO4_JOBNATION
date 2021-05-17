package com.tecnocode.converter;

import com.tecnocode.model.*;
import org.springframework.core.convert.converter.Converter;
import com.tecnocode.payload.CandidateDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CandidateToDtoConverter implements Converter<Candidate, CandidateDTO> {
    @Override
    public CandidateDTO convert(Candidate candidate){
        return CandidateDTO.builder()
                .addressId(candidate.getAddress().getId())
                .cpf(candidate.getCpf())
                .firstName(candidate.getFirstName())
                .middleName(candidate.getMiddleName())
                .surname(candidate.getSurname())
                .gender(candidate.getGender())
                .marital(candidate.getMarital())
                .birth(candidate.getBirth())
                .marital(candidate.getMarital())
                .email(candidate.getEmail())
                .mobile(candidate.getMobile())
                .phone(candidate.getPhone())
                .experiences(candidate.getExperiences().stream().map(Experience::getId).collect(Collectors.toSet()))
                .qualifications(candidate.getQualifications().stream().map(Qualification::getId).collect(Collectors.toSet()))
                .skills(candidate.getSkills().stream().map(Skill::getId).collect(Collectors.toSet()))
                .languages(candidate.getLanguages().stream().map(Language::getId).collect(Collectors.toSet()))
                .build();
    }
}
