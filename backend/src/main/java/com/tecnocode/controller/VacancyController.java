package com.tecnocode.controller;

import com.tecnocode.converter.DtoToVacancyConverter;
import com.tecnocode.converter.VacancyToDtoConverter;
import com.tecnocode.model.*;
import com.tecnocode.payload.MatchPayload;
import com.tecnocode.payload.VacancyDTO;
import com.tecnocode.service.VacancyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService service;
    private final DtoToVacancyConverter dtoToVacancyConverter;
    private final VacancyToDtoConverter vacancyToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final VacancyDTO vacancyDTO) {
        try {
            Vacancy vacancy = service.save(dtoToVacancyConverter.convert(vacancyDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(vacancyToDtoConverter.convert(vacancy));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{company}")
    public List<Vacancy> buscarTodasVagasDestaEmpresa(@PathVariable("company") Company company){
        return service.buscarTodasVagasDestaEmpresa(company);
    }

    @GetMapping("/{address}")
    public List<Vacancy> buscarTodasVagasDesteEndereco(@PathVariable("address") Address address){
        return service.buscarTodasVagasDesteEndereco(address);
    }

    @GetMapping("/{title}")
    public List<Vacancy> buscarTodasVagasComEsteTitulo(@PathVariable("title") String title){
        return service.buscarTodasVagasComEsteTitulo(title);
    }

    @GetMapping("/{minSalary}")
    public List<Vacancy> buscarTodasVagasComEsteSalMin(@PathVariable("minSalary") Double minSalary){
        return service.buscarTodasVagasComEsteSalMin(minSalary);
    }

    @GetMapping("/{maxSalary}")
    public List<Vacancy> buscarTodasVagasComEsteSalMax(@PathVariable("maxSalary") Double maxSalary){
        return service.buscarTodasVagasComEsteSalMax(maxSalary);
    }

    @GetMapping("/{openDate}")
    public List<Vacancy> buscarTodasVagasComEstaDataDeAbertura(@PathVariable("openDate") LocalDate openDate){
        return service.buscarTodasVagasComEstaDataDeAbertura(openDate);
    }

    @GetMapping("/{closeDate}")
    public List<Vacancy> buscarTodasVagasComEstaDataDeFechamento(@PathVariable("closeDate") LocalDate closeDate){
        return service.buscarTodasVagasComEstaDataDeFechamento(closeDate);
    }

    @GetMapping("/{qualifications}")
    public List<Vacancy> buscarTodasVagasComEstaQualificacao(@PathVariable("qualifications") Qualification qualifications){
        return service.buscarTodasVagasComEstaQualificacao(qualifications);
    }

    @GetMapping("/{skills}")
    public List<Vacancy> buscarTodasVagasComEstaSkill(@PathVariable("qualifications") Skill skills){
        return service.buscarTodasVagasComEstaSkill(skills);
    }

    @GetMapping("/{languages}")
    public List<Vacancy> buscarTodasVagasComEstaLingua(@PathVariable("languages") Language languages){
        return service.buscarTodasVagasComEstaLingua(languages);
    }

    @GetMapping("/{benefits}")
    public List<Vacancy> buscarTodasVagasComEsteBeneficio(@PathVariable("benefits") Benefit benefits){
        return service.buscarTodasVagasComEsteBeneficio(benefits);
    }

    @GetMapping("/match/{id_vaga}")
    public List<MatchPayload> buscarTodasOsCandidatosVaga(@PathVariable("id_vaga") Integer id){
        List<Apply> applies = service.buscarTodasOsCandidatosVaga(id);
        List<Candidate> candidates = applies.stream().map(Apply::getCandidate).collect(Collectors.toList());
        Vacancy vacancy = applies.stream().map(Apply::getVacancy).findFirst().get();
        return transformWithGrade(candidates, vacancy);
    }

    private List<MatchPayload> transformWithGrade(List<Candidate> candidates, Vacancy vacancy) {
        List<MatchPayload> matchPayloads = candidates.stream().filter(Objects::nonNull).map(candidate -> {
            Integer candidateLanguageGrade = candidate.getLanguages().stream().filter(language -> vacancy.getLanguages().contains(language)).collect(Collectors.toList()).size();
            Integer candidateSkillGrade = candidate.getSkills().stream().filter(skill -> vacancy.getSkills().contains(skill)).collect(Collectors.toList()).size();
            Integer candidateQualificationGrade = candidate.getQualifications().stream().filter(qualification -> vacancy.getQualifications().contains(qualification)).collect(Collectors.toList()).size();
            return MatchPayload.builder()
                    .candidateName(candidate.getFirstName() + " " + candidate.getMiddleName())
                    .languageGrade(candidateLanguageGrade)
                    .qualificationGrade(candidateQualificationGrade)
                    .skillGrade(candidateSkillGrade)
                    .companyName(vacancy.getCompany().getName())
                    .vacancyTitle(vacancy.getTitle())
                    .build();
        }).collect(Collectors.toList());

        matchPayloads.sort(Comparator.comparing(MatchPayload::getLanguageGrade)
                .reversed()
                .thenComparing(MatchPayload::getSkillGrade)
                .reversed()
                .thenComparing(MatchPayload::getQualificationGrade)
                .reversed());
        return matchPayloads;
    }

}
