package com.tecnocode.service.impl;

import com.tecnocode.model.Skill;
import com.tecnocode.repository.SkillRepository;
import com.tecnocode.service.SkillService;
import com.tecnocode.validator.Operation;
import com.tecnocode.validator.SkillValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    private final Map<Operation, SkillValidator> skillValidators;

    @Override
    public Skill save(final Skill skill, Operation operation) {
        skillValidators.get(operation).validate(skill);
        return repository.saveAndFlush(skill);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Skill> buscarTodosComEsteNome(String name) {
        return repository.findAllBySkillName(name);
    }

    @Override
    public List<Skill> buscarTodosComEsteNivel(String level) {
        return repository.findAllBySkillLevel(level);
    }
}