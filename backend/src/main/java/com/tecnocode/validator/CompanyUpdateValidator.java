package com.tecnocode.validator;

import com.tecnocode.model.Company;

import com.tecnocode.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;


@Component
@RequiredArgsConstructor
public class CompanyUpdateValidator  implements CompanyValidator {

    private final CompanyRepository companyRepository;

    @Override
    public void validate(Company company) {
        if(isNull(company.getId())) {
            throw new RuntimeException("O ID da empresa deverá ser informado.");
        }
        if(!companyRepository.findById(company.getId()).isPresent()) {
            throw new RuntimeException("A empresa informada para atualizar não existe.");
        }
    }
}
