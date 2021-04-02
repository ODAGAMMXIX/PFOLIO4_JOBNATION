package com.tecnocode.controller;

import com.tecnocode.converter.AddressToDtoConverter;
import com.tecnocode.converter.DtoToAddressConverter;
import com.tecnocode.model.Address;
import com.tecnocode.payload.AddressDTO;
import com.tecnocode.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;
    private final DtoToAddressConverter dtoToAddressConverter;
    private final AddressToDtoConverter addressToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final AddressDTO addressDTO) {
        try {
            Address address = service.save(dtoToAddressConverter.convert(addressDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(addressToDtoConverter.convert(address));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
