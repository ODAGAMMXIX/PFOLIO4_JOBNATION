package com.tecnocode.controller;

import com.tecnocode.converter.DtoToQualificationConverter;
import com.tecnocode.converter.QualificationToDtoConverter;
import com.tecnocode.model.Qualification;
import com.tecnocode.payload.QualificationDTO;
import com.tecnocode.service.QualificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/qualification")
@RequiredArgsConstructor
public class QualificationController {
    private final QualificationService service;
    private final DtoToQualificationConverter dtoToQualificationConverter;
    private final QualificationToDtoConverter qualificationToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final QualificationDTO qualificationDTO) {
        try {
            Qualification qualification = service.save(dtoToQualificationConverter.convert(qualificationDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(qualificationToDtoConverter.convert(qualification));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
