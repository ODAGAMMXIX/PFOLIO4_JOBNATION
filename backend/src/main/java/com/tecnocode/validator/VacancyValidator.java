package com.tecnocode.validator;

import com.tecnocode.model.Vacancy;
import com.tecnocode.repository.AddressRepository;
import com.tecnocode.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class VacancyValidator implements AbstractValidator<Vacancy> {

    private final CompanyRepository companyRepository;

    private final AddressRepository addressRepository;

    @Override
    public void validate(Vacancy vacancy){
        if(isNull(vacancy.getCompany()) || isNull(vacancy.getCompany().getId())){
            throw new RuntimeException("Empresa não pode ser vazio.");
        }
        if(!companyRepository.findById(vacancy.getCompany().getId()).isPresent()) {
            throw new RuntimeException("A Empresa informada não existe.");
        }

        if(isNull(vacancy.getAddress()) || isNull(vacancy.getAddress().getId())){
            throw new RuntimeException("endereço não pode ser vazio.");
        }

        if(!addressRepository.findById(vacancy.getAddress().getId()).isPresent()){
            throw new RuntimeException("O endereço informado não existe.");
        }

        if(vacancy.getTitle().isEmpty()){
            throw new RuntimeException("O titulo não pode ser vazio.");
        }
        if(vacancy.getDescription().isEmpty()){
            throw new RuntimeException("A descrição não pode ser vazio.");
        }
        if(isNull(vacancy.getOpenDate())){
            throw new RuntimeException("A data de abertura da vaga não pode ser vazia.");
        }
        if(isNull(vacancy.getCloseDate())){
            throw new RuntimeException("A data de fechamento da vaga não pode ser vazia.");
        }
        if(vacancy.getContract().isEmpty()){
            throw new RuntimeException("Empresa não pode ser vazio.");
        }

    }
}
