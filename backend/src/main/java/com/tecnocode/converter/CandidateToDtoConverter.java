package com.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import com.tecnocode.model.Candidate;
import com.tecnocode.payload.CandidateDTO;
import org.springframework.stereotype.Component;

@Component
public class CandidateToDtoConverter implements Converter<Candidate, CandidateDTO> {
    @Override
    public CandidateDTO convert(Candidate candidate){
        return CandidateDTO.builder()
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
                .build();
    }
}
