package com.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import com.tecnocode.model.Candidate;
import com.tecnocode.payload.CandidateDTO;
import org.springframework.stereotype.Component;

@Component
public class DtoToCandidateConverter implements Converter<CandidateDTO, Candidate> {
    @Override
    public Candidate convert(CandidateDTO candidateDTO){
        return Candidate.builder()
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
                .build();
    }
}
