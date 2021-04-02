package com.tecnocode.converter;

import com.tecnocode.model.Address;
import com.tecnocode.payload.AddressDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressToDtoConverter implements Converter<Address, AddressDTO> {
    @Override
    public AddressDTO convert(Address address){
        return AddressDTO.builder()
                .cep(address.getCep())
                .city(address.getCity())
                .country(address.getCountry())
                .detail(address.getDetail())
                .hood(address.getHood())
                .number(address.getNumber())
                .state(address.getState())
                .street(address.getStreet())
                .build();
    }
}
