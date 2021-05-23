package com.tecnocode.validator;

import static java.util.Objects.isNull;

import org.springframework.stereotype.Component;

import com.tecnocode.model.Address;
import com.tecnocode.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AddressDeleteValidator implements AddressValidator {
    private final AddressRepository addressRepository;

    @Override
    public void validate(Address address) {
        if(isNull(address.getId())) {
            throw new RuntimeException("O ID do endereço deverá ser informado.");
        }
        if(!addressRepository.findById(address.getId()).isPresent()) {
            throw new RuntimeException("O endereço informado para deletar não existe.");
        }
    }

}
