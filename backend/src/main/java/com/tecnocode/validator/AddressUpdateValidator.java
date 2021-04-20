package com.tecnocode.validator;

import com.tecnocode.model.Address;
import com.tecnocode.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class AddressUpdateValidator implements AddressValidator {
    private final AddressRepository addressRepository;

    @Override
    public void validate(Address address) {
        if(isNull(address.getId())) {
            throw new RuntimeException("O ID do endereço deverá ser informado.");
        }
        if(!addressRepository.findById(address.getId()).isPresent()) {
            throw new RuntimeException("O endereço informado para atualizar não existe.");
        }
    }
}
