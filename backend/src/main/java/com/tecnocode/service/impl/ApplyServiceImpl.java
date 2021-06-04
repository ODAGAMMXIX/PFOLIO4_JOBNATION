package com.tecnocode.service.impl;

import com.tecnocode.model.Apply;
import com.tecnocode.repository.ApplyRepository;
import com.tecnocode.repository.ApplySpecification;
import com.tecnocode.service.ApplyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {
    private final ApplyRepository repository;

    @Override
    public Apply save(final Apply apply, Operation operation) {
        return repository.saveAndFlush(apply);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Apply> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Apply> search(final Integer vacancyId, final String gender, Set<String> languages, final Set<String> qualifications, final Set<String> skills) {
        if(isNull(vacancyId)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "O ID da vaga é obrigatório.");
        }
        return repository.findAll(new ApplySpecification(vacancyId,gender, languages, qualifications, skills));
    }

}
