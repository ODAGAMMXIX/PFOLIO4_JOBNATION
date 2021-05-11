package com.tecnocode.validator;

import com.tecnocode.model.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillValidator implements AbstractValidator<Skill> {
    @Override
    public void validate(Skill skill) {
        if (skill.getName().isEmpty()) {
            throw new RuntimeException("O nome da skill não pode ser vir vazio.");
        }
        if (skill.getLevel().isEmpty()) {
            throw new RuntimeException("O nível da skill não pode ser vir vazio.");
        }
    }
}
