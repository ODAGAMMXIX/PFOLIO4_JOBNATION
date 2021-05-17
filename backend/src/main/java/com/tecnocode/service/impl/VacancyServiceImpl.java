package com.tecnocode.service.impl;

import com.tecnocode.model.*;
import com.tecnocode.repository.ApplyRepository;
import com.tecnocode.repository.VacancyRepository;
import com.tecnocode.service.VacancyService;
import com.tecnocode.validator.Operation;
import com.tecnocode.validator.VacancyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository repository;
    private final VacancyValidator validator;
    private final ApplyRepository applyRepository;

    @Override
    public Vacancy save(final Vacancy vacancy, Operation operation) {
        validator.validate(vacancy);
        return repository.saveAndFlush(vacancy);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Vacancy> buscarTodasVagasDestaEmpresa(Company company) {
        return repository.findAllByCompany(company);
    }

    @Override
    public List<Vacancy> buscarTodasVagasDesteEndereco(Address address) {
        return repository.findAllByAddress(address);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEsteTitulo(String title) {
        return repository.findAllByTitle(title);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEsteSalMin(Double minSalary) {
        return repository.findAllByMinSalary(minSalary);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEsteSalMax(Double maxSalary) {
        return repository.findAllByMaxSalary(maxSalary);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEstaDataDeAbertura(LocalDate openDate) {
        return repository.findAllByOpenDate(openDate);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEstaDataDeFechamento(LocalDate closeDate) {
        return repository.findAllByCloseDate(closeDate);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEstaQualificacao(Qualification qualifications) {
        return repository.findAllByQualification(qualifications);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEstaSkill(Skill skills) {
        return repository.findAllBySkill(skills);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEstaLingua(Language languages) {
        return repository.findAllByLanguage(languages);
    }

    @Override
    public List<Vacancy> buscarTodasVagasComEsteBeneficio(Benefit benefits) {
        return repository.findAllByBenefit(benefits);
    }

    @Override
    public List<Apply> buscarTodasOsCandidatosVaga(Integer id) {
        return applyRepository.findAllByVacancyId(id);
    }

}
