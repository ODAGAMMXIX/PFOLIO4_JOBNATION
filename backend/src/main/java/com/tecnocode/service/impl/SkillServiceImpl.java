package com.tecnocode.service.impl;

import com.tecnocode.model.Skill;
import com.tecnocode.repository.SkillRepository;
import com.tecnocode.service.SkillService;
import com.tecnocode.validator.SkillValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;
    private final SkillValidator validator;

    @Override
    public Skill save(final Skill skill) {
        validator.validate(skill);
        return repository.saveAndFlush(skill);
    }
}