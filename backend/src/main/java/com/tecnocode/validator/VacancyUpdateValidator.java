package com.tecnocode.validator;

import com.tecnocode.model.Vacancy;
import com.tecnocode.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
@Component
@RequiredArgsConstructor
public class VacancyUpdateValidator  implements VacancyValidator {
    private final VacancyRepository vacancyRepository;

    @Override
    public void validate(Vacancy vacancy) {
        if(isNull(vacancy.getId())) {
            throw new RuntimeException("O ID da vaga deverá ser informado.");
        }
        if(!vacancyRepository.findById(vacancy.getId()).isPresent()) {
            throw new RuntimeException("A vaga para atualizar não existe.");
        }
    }
}