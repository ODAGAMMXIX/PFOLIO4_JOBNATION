package com.tecnocode.service.impl;

import com.tecnocode.model.Company;
import com.tecnocode.repository.CompanyRepository;
import com.tecnocode.service.CompanyService;
import com.tecnocode.validator.CompanyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyValidator validator;

    @Override
    public Company save(final Company company) {
        validator.validate(company);
        return repository.saveAndFlush(company);
    }
}