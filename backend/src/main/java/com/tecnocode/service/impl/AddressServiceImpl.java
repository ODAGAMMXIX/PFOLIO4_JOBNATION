package com.tecnocode.service.impl;

import com.tecnocode.model.Address;
import com.tecnocode.repository.AddressRepository;
import com.tecnocode.service.AddressService;
import com.tecnocode.validator.AddressInsertValidator;
import com.tecnocode.validator.AddressValidator;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final Map<Operation, AddressValidator> validator;

    @Override
    public Address save(final Address address, final Operation operation) {
        validator.get(operation).validate(address);
        return repository.saveAndFlush(address);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Address> buscarTodosComEstaCidade(String city) {
        return repository.findAllByCity(city);
    }

    @Override
    public List<Address> buscarTodosComEsteEstado(String state) {
        return repository.findAllByState(state);
    }

    @Override
    public List<Address> buscarTodosComEstePais(String country) {
        return repository.findAllByCountry(country);
    }

    @Override
    public List<Address> buscarTodos() {
        return repository.findAll();
    }
}
