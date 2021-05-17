package com.tecnocode.service;

import com.tecnocode.model.*;

import java.time.LocalDate;
import java.util.List;

public interface VacancyService extends GenericService<Vacancy> {
    List<Vacancy> buscarTodasVagasDestaEmpresa(final Company company);

    List<Vacancy> buscarTodasVagasDesteEndereco(final Address address);

    List<Vacancy> buscarTodasVagasComEsteTitulo(final String title);

    List<Vacancy> buscarTodasVagasComEsteSalMin(final Double minSalary);

    List<Vacancy> buscarTodasVagasComEsteSalMax(final Double maxSalary);

    List<Vacancy> buscarTodasVagasComEstaDataDeAbertura(final LocalDate openDate);

    List<Vacancy> buscarTodasVagasComEstaDataDeFechamento(final LocalDate closeDate);

    List<Vacancy> buscarTodasVagasComEstaQualificacao(final Qualification qualifications);

    List<Vacancy> buscarTodasVagasComEstaSkill(final Skill skills);

    List<Vacancy> buscarTodasVagasComEstaLingua(final Language languages);

    List<Vacancy> buscarTodasVagasComEsteBeneficio(final Benefit benefits);

    List<Apply> buscarTodasOsCandidatosVaga(Integer id);
}
