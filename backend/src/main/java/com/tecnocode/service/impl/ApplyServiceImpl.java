package com.tecnocode.service.impl;

import com.tecnocode.model.Apply;
import com.tecnocode.repository.ApplyRepository;
import com.tecnocode.service.ApplyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Apply search(final Apply apply, Operation operation) {
        return repository.search();
    }
}
