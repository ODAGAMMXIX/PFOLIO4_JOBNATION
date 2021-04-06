package com.tecnocode.service.impl;

import com.tecnocode.model.Vacancy;
import com.tecnocode.repository.VacancyRepository;
import com.tecnocode.service.VacancyService;
import com.tecnocode.validator.VacancyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository repository;
    private final VacancyValidator validator;

    @Override
    public Vacancy save(final Vacancy vacancy) {
        validator.validate(vacancy);
        return repository.saveAndFlush(vacancy);
    }
}
