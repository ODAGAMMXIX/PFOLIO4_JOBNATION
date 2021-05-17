package com.tecnocode.controller;

import com.tecnocode.converter.CompanyToDtoConverter;
import com.tecnocode.converter.DtoToCompanyConverter;
import com.tecnocode.model.Address;
import com.tecnocode.model.Company;
import com.tecnocode.payload.CompanyDTO;
import com.tecnocode.service.CompanyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;
    private final DtoToCompanyConverter dtoToCompanyConverter;
    private final CompanyToDtoConverter companyToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final CompanyDTO companyDTO) {
        try {
            Company company = service.save(dtoToCompanyConverter.convert(companyDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(companyToDtoConverter.convert(company));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{address}")
    public List<Company> buscarTodosComEsteEndereco(@PathVariable("address") Address address) {
        return service.buscarTodosComEsteEndereco(address);
    }

    @GetMapping("/name/{name}")
    public List<Company> buscarTodosComEstaCompanhia(@PathVariable("name") String name) {
        return service.buscarTodosComEstaCompanhia(name);
    }

    @GetMapping("/cnpj/{cnpj}")
    public List<Company> buscarTodosComEsteCnpj(@PathVariable("cnpj") String cnpj) {
        return service.buscarTodosComEsteCnpj(cnpj);
    }

}
