package com.tecnocode.validator;

import com.tecnocode.model.Candidate;
import com.tecnocode.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
@Component
@RequiredArgsConstructor
public class CandidateUpdateValidator implements CandidateValidator {
    private final CandidateRepository candidateRepository;

    @Override
    public void validate(Candidate candidate) {
        if(isNull(candidate.getId())) {
            throw new RuntimeException("O ID do endereço deverá ser informado.");
        }
        if(!candidateRepository.findById(candidate.getId()).isPresent()) {
            throw new RuntimeException("O endereço informado para atualizar não existe.");
        }
    }
}