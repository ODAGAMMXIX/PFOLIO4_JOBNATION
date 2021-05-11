package com.tecnocode.converter;

import com.tecnocode.model.Address;
import com.tecnocode.payload.AddressDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToAddressConverter implements Converter<AddressDTO, Address> {
    @Override
    public Address convert(AddressDTO addressDTO) {
        return Address.builder()
                .cep(addressDTO.getCep())
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .detail(addressDTO.getDetail())
                .hood(addressDTO.getHood())
                .number(addressDTO.getNumber())
                .state(addressDTO.getState())
                .street(addressDTO.getStreet())
                .build();
    }
}
