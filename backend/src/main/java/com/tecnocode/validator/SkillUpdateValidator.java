package com.tecnocode.validator;

import com.tecnocode.model.Skill;
import com.tecnocode.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class SkillUpdateValidator implements SkillValidator {
    private final SkillRepository skillRepository;

    @Override
    public void validate(Skill skill) {
        if(isNull(skill.getId())) {
            throw new RuntimeException("O ID do endereço deverá ser informado.");
        }
        if(!skillRepository.findById(skill.getId()).isPresent()) {
            throw new RuntimeException("O endereço informado para atualizar não existe.");
        }
    }
}
