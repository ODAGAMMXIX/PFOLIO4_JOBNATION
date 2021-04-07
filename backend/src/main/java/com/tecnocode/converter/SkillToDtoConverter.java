package com.tecnocode.converter;

import com.tecnocode.model.Skill;
import com.tecnocode.payload.SkillDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SkillToDtoConverter implements Converter<Skill, SkillDTO> {
    @Override
    public SkillDTO convert(Skill skill){
        return SkillDTO.builder()
                .name(skill.getName())
                .level(skill.getLevel())
                .others(skill.getOthers())
                .build();
    }
}
