package com.tecnocode.service.impl;

import com.tecnocode.model.*;
import com.tecnocode.repository.CandidateRepository;
import com.tecnocode.service.CandidateService;
import com.tecnocode.validator.CandidateValidator;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository repository;
    private final CandidateValidator validator;

    @Override
    public Candidate save(final Candidate candidate, Operation operation) {
        validator.validate(candidate);
        return repository.saveAndFlush(candidate);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosDesteEndereco(Address address) {
        return repository.findAllByAddress(address);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEstaExperiencia(Experience experience) {
        return repository.findAllByExperience(experience);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEstaQualificacao(Qualification qualification) {
        return repository.findAllByQualification(qualification);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEstaSkill(Skill skill) {
        return repository.findAllBySkill(skill);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEstaLingua(Language language) {
        return repository.findAllByLanguage(language);
    }

    @Override
    public List<Candidate> buscarCandidatoComEsteCpf(String cpf) {
        return repository.findAllByCpf(cpf);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEstePrimeiroNome(String firstName) {
        return repository.findAllByFirstName(firstName);
    }
    @Override
    public List<Candidate> buscarTodosCandidatosComEsteSobrenome(String middleName) {
        return repository.findAllByMiddleName(middleName);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEsteUltimoNome(String surname) {
        return repository.findAllBySurname(surname);
    }

    @Override
    public List<Candidate> buscarTodosCandidatosComEsteGenero(String gender) {
        return repository.findAllByGender(gender);
    }
}
