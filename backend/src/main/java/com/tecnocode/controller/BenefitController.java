package com.tecnocode.controller;

import com.tecnocode.converter.BenefitToDtoConverter;
import com.tecnocode.converter.DtoToBenefitConverter;
import com.tecnocode.model.Benefit;
import com.tecnocode.payload.BenefitDTO;
import com.tecnocode.service.BenefitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benefit")
@RequiredArgsConstructor
public class BenefitController {
    private final BenefitService service;
    private final DtoToBenefitConverter dtoToBenefitConverter;
    private final BenefitToDtoConverter benefitToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final BenefitDTO benefitDTO) {
        try {
            Benefit benefit = service.save(dtoToBenefitConverter.convert(benefitDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(benefitToDtoConverter.convert(benefit));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
