package com.tecnocode.service.impl;

import com.tecnocode.model.Qualification;
import com.tecnocode.repository.QualificationRepository;
import com.tecnocode.service.QualificationService;
import com.tecnocode.validator.Operation;
import com.tecnocode.validator.QualificationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QualificationServiceImpl implements QualificationService {
    private final QualificationRepository repository;
    private final QualificationValidator validator;

    @Override
    public Qualification save(final Qualification qualification, Operation operation) {
        validator.validate(qualification);
        return repository.saveAndFlush(qualification);
    }

    @Override
    public void delete(Integer id) {

    }
}
