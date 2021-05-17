package com.tecnocode.service;

import com.tecnocode.model.Address;
import com.tecnocode.model.Company;

import java.util.List;

public interface CompanyService extends GenericService<Company> {
    List<Company> buscarTodosComEsteEndereco(final Address address);

    List<Company> buscarTodosComEstaCompanhia(final String name);

    List<Company> buscarTodosComEsteCnpj(final String cnpj);

}
