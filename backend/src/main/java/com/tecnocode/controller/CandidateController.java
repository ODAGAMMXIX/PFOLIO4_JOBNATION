package com.tecnocode.controller;

import com.tecnocode.converter.CandidateToDtoConverter;
import com.tecnocode.converter.DtoToCandidateConverter;
import com.tecnocode.model.*;
import com.tecnocode.payload.CandidateDTO;
import com.tecnocode.service.CandidateService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
            Candidate candidate = service.save(dtoToCandidateConverter.convert(candidateDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidateToDtoConverter.convert(candidate));
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
    public List<Candidate> buscarTodosCandidatosDesteEndereco(@PathVariable("address") Address address){
        return service.buscarTodosCandidatosDesteEndereco(address);
    }

    @GetMapping("/{experiences}")
    public List<Candidate> buscarTodosCandidatosComEstaExperiencia(@PathVariable("experience") Experience experience){
        return service.buscarTodosCandidatosComEstaExperiencia(experience);
    }

    @GetMapping("/{qualifications}")
    public List<Candidate> buscarTodosCandidatosComEstaQualificacao(@PathVariable("qualifications") Qualification qualifications){
        return service.buscarTodosCandidatosComEstaQualificacao(qualifications);
    }

    @GetMapping("/{skills}")
    public List<Candidate> buscarTodosCandidatosComEstaSkill(@PathVariable("qualifications") Skill skills){
        return service.buscarTodosCandidatosComEstaSkill(skills);
    }

    @GetMapping("/{languages}")
    public List<Candidate> buscarTodosCandidatosComEstaLingua(@PathVariable("languages") Language languages){
        return service.buscarTodosCandidatosComEstaLingua(languages);
    }

    @GetMapping("/{cpf}")
    public List<Candidate> buscarCandidatoComEsteCpf(@PathVariable("cpf") String cpf){
        return service.buscarCandidatoComEsteCpf(cpf);
    }

    @GetMapping("/{firstName}")
    public List<Candidate> buscarTodosCandidatosComEstePrimeiroNome(@PathVariable("firstName") String firstName){
        return service.buscarTodosCandidatosComEstePrimeiroNome(firstName);
    }

    @GetMapping("/{middleName}")
    public List<Candidate> buscarTodosCandidatosComEsteSobrenome(@PathVariable("middleName") String middleName){
        return service.buscarTodosCandidatosComEsteSobrenome(middleName);
    }

    @GetMapping("/{surname}")
    public List<Candidate> buscarTodosCandidatosComEsteUltimoNome(@PathVariable("surname") String surname){
        return service.buscarTodosCandidatosComEsteUltimoNome(surname);
    }

    @GetMapping("/{gender}")
    public List<Candidate> buscarTodosCandidatosComEsteGenero(@PathVariable("gender") String gender){
        return service.buscarTodosCandidatosComEsteGenero(gender);
    }

    @GetMapping("/all")
    public List<Candidate> buscarTodos(){
        return service.buscarTodos();
    }
}
