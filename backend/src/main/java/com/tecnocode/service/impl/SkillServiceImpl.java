package com.tecnocode.service.impl;

import com.tecnocode.model.Skill;
import com.tecnocode.repository.SkillRepository;
import com.tecnocode.service.SkillService;
import com.tecnocode.validator.Operation;
import com.tecnocode.validator.SkillValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    private final SkillValidator validator;

    @Override
    public Skill save(final Skill skill, Operation operation) {
        validator.validate(skill);
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