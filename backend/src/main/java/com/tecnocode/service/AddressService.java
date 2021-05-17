package com.tecnocode.service;

import com.tecnocode.model.Address;

import java.util.List;

public interface AddressService extends GenericService<Address> {
    List<Address> buscarTodosComEstaCidade(String city);

    List<Address> buscarTodosComEsteEstado(String state);

    List<Address> buscarTodosComEstePais(String country);

    List<Address> buscarTodos();
}
