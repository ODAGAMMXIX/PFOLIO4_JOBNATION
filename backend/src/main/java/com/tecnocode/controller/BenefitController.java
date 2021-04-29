package com.tecnocode.controller;

import com.tecnocode.converter.BenefitToDtoConverter;
import com.tecnocode.converter.DtoToBenefitConverter;
import com.tecnocode.model.Benefit;
import com.tecnocode.payload.BenefitDTO;
import com.tecnocode.service.BenefitService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefit")
@RequiredArgsConstructor
public class BenefitController {
    private final BenefitService service;
    private final DtoToBenefitConverter dtoToBenefitConverter;
    private final BenefitToDtoConverter benefitToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final BenefitDTO benefitDTO) {
        try {
            Benefit benefit = service.save(dtoToBenefitConverter.convert(benefitDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(benefitToDtoConverter.convert(benefit));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{benefit}")
    public List<Benefit> buscarTodosComEsteBeneficio(@PathVariable("benefit") String benefit){
        return service.buscarTodosComEsteBeneficio(benefit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
