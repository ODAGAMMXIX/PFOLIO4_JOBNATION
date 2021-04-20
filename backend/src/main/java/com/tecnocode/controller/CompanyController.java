package com.tecnocode.controller;

import com.tecnocode.converter.CompanyToDtoConverter;
import com.tecnocode.converter.DtoToCompanyConverter;
import com.tecnocode.model.Company;
import com.tecnocode.payload.CompanyDTO;
import com.tecnocode.service.CompanyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;
    private final DtoToCompanyConverter dtoToCompanyConverter;
    private final CompanyToDtoConverter companyToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final CompanyDTO companyDTO) {
        try {
            Company company = service.save(dtoToCompanyConverter.convert(companyDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(companyToDtoConverter.convert(company));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
