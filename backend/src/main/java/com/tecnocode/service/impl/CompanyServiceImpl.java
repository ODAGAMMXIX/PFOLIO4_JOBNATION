package com.tecnocode.service.impl;

import com.tecnocode.model.Address;
import com.tecnocode.model.Company;
import com.tecnocode.repository.CompanyRepository;
import com.tecnocode.service.CompanyService;
import com.tecnocode.validator.CompanyValidator;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyValidator validator;

    @Override
    public Company save(final Company company, Operation operation) {
        validator.validate(company);
        return repository.saveAndFlush(company);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Company> buscarTodosComEsteEndereco(Address address) {
        return repository.findAllByAddress(address);
    }

    @Override
    public List<Company> buscarTodosComEstaCompanhia(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public List<Company> buscarTodosComEsteCnpj(String cnpj) {
        return repository.findAllByCnpj(cnpj);
    }

}
