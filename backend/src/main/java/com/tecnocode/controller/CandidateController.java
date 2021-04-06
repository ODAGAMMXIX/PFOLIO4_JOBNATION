package com.tecnocode.controller;

import com.tecnocode.converter.BenefitToDtoConverter;
import com.tecnocode.converter.CandidateToDtoConverter;
import com.tecnocode.converter.DtoToBenefitConverter;
import com.tecnocode.converter.DtoToCandidateConverter;
import com.tecnocode.model.Benefit;
import com.tecnocode.model.Candidate;
import com.tecnocode.payload.BenefitDTO;
import com.tecnocode.payload.CandidateDTO;
import com.tecnocode.service.BenefitService;
import com.tecnocode.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService service;
    private final DtoToCandidateConverter dtoToCandidateConverter;
    private final CandidateToDtoConverter candidateToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final CandidateDTO candidateDTO) {
        try {
            Candidate candidate = service.save(dtoToCandidateConverter.convert(candidateDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(candidateToDtoConverter.convert(candidate));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
