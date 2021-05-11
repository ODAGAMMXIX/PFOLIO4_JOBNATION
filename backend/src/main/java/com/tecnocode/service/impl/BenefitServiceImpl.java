package com.tecnocode.service.impl;

import com.tecnocode.model.Benefit;
import com.tecnocode.repository.BenefitRepository;
import com.tecnocode.service.BenefitService;
import com.tecnocode.validator.BenefitValidator;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {
    private final BenefitRepository repository;
    private final BenefitValidator validator;

    @Override
    public Benefit save(final Benefit benefit, Operation operation) {
        validator.validate(benefit);
        return repository.saveAndFlush(benefit);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Benefit> buscarTodosComEsteBeneficio(String benefit) {
        return repository.findAllByBenefit(benefit);
    }


}
