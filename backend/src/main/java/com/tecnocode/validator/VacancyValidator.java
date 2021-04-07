package com.tecnocode.validator;

import com.tecnocode.model.Vacancy;
import org.springframework.stereotype.Component;

@Component
public class VacancyValidator implements AbstractValidator<Vacancy> {
    @Override
    public void validate(Vacancy vacancy){
//        if(vacancy.getCompany().isEmpty()){
//            throw new RuntimeException("Empresa não pode ser vazio.");
//        }
//        if(vacancy.getAddress().isEmpty()){
//            throw new RuntimeException("O endereço não pode ser vazio.");
//        }
        if(vacancy.getTitle().isEmpty()){
            throw new RuntimeException("O titulo não pode ser vazio.");
        }
        if(vacancy.getDescription().isEmpty()){
            throw new RuntimeException("A descrição não pode ser vazio.");
        }
//        if(vacancy.getOpenDate().isEmpty()){
//            throw new RuntimeException("A data de abertura da vaga não pode ser vazia.");
//        }
//        if(vacancy.getCloseDate().isEmpty()){
//            throw new RuntimeException("A data de fechamento da vaga não pode ser vazia.");
//        }
//        if(vacancy.getContract().isEmpty()){
//            throw new RuntimeException("Empresa não pode ser vazio.");
//        }

    }
}
