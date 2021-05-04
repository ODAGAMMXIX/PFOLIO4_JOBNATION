package com.tecnocode.service;

import com.tecnocode.model.*;
import java.util.List;

public interface CandidateService extends GenericService<Candidate> {

    List<Candidate> buscarTodosCandidatosDesteEndereco(final Address address);

    List<Candidate> buscarTodosCandidatosComEstaExperiencia(final Experience experience);

    List<Candidate> buscarTodosCandidatosComEstaQualificacao(final Qualification qualifications);

    List<Candidate> buscarTodosCandidatosComEstaSkill(final Skill skills);

    List<Candidate> buscarTodosCandidatosComEstaLingua(final Language languages);

    List<Candidate> buscarCandidatoComEsteCpf(final String cpf);

    List<Candidate> buscarTodosCandidatosComEstePrimeiroNome(final String firstName);

    List<Candidate> buscarTodosCandidatosComEsteSobrenome(final String middleName);

    List<Candidate> buscarTodosCandidatosComEsteUltimoNome(final String surname);

    List<Candidate> buscarTodosCandidatosComEsteGenero(final String gender);



}
