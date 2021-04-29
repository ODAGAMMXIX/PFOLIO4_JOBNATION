package com.tecnocode.service.impl;

import com.tecnocode.model.Candidate;
import com.tecnocode.repository.CandidateRepository;
import com.tecnocode.service.CandidateService;
import com.tecnocode.validator.CandidateValidator;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository repository;
    private final CandidateValidator validator;

    @Override
    public Candidate save(final Candidate candidate, Operation operation) {
        validator.validate(candidate);
        return repository.saveAndFlush(candidate);
    }

    @Override
    public void delete(Integer id) {

    }
}
