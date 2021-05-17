package com.tecnocode.controller;

import com.tecnocode.converter.AddressToDtoConverter;
import com.tecnocode.converter.DtoToAddressConverter;
import com.tecnocode.model.Address;
import com.tecnocode.payload.AddressDTO;
import com.tecnocode.service.AddressService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;
    private final DtoToAddressConverter dtoToAddressConverter;
    private final AddressToDtoConverter addressToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final AddressDTO addressDTO) {
        try {
            Address address = service.save(dtoToAddressConverter.convert(addressDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(addressToDtoConverter.convert(address));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping
    public List<Address> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{city}")
    public List<Address> buscarTodosComEstaCidade(@PathVariable("city") String city){
        return service.buscarTodosComEstaCidade(city);
    }

    @GetMapping("/{state}")
    public List<Address> buscarTodosComEsteEstado(@PathVariable("state") String state){
        return service.buscarTodosComEsteEstado(state);
    }

    @GetMapping("/{country}")
    public List<Address> buscarTodosComEstePais(@PathVariable("country") String country){
        return service.buscarTodosComEstePais(country);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
