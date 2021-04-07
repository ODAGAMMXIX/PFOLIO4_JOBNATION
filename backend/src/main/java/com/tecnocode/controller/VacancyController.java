package com.tecnocode.controller;



import com.tecnocode.converter.DtoToVacancyConverter;
import com.tecnocode.converter.VacancyToDtoConverter;
import com.tecnocode.model.Vacancy;
import com.tecnocode.payload.SkillDTO;
import com.tecnocode.payload.VacancyDTO;
import com.tecnocode.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService service;
    private final DtoToVacancyConverter dtoToVacancyConverter;
    private final VacancyToDtoConverter vacancyToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final VacancyDTO vacancyDTO) {
        try {
            Vacancy vacancy = service.save(dtoToVacancyConverter.convert(vacancyDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(vacancyToDtoConverter.convert(vacancy));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
