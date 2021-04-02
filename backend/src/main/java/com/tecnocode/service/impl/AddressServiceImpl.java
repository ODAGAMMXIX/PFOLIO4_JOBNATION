package com.tecnocode.service.impl;

import com.tecnocode.model.Address;
import com.tecnocode.repository.AddressRepository;
import com.tecnocode.service.AddressService;
import com.tecnocode.validator.AddressValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressValidator validator;

    @Override
    public Address save(final Address address) {
        validator.validate(address);
        return repository.saveAndFlush(address);
    }
}
