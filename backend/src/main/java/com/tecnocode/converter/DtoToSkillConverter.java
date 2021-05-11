package com.tecnocode.converter;

import com.tecnocode.model.Skill;
import com.tecnocode.payload.SkillDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToSkillConverter implements Converter<SkillDTO, Skill> {
    @Override
    public Skill convert(SkillDTO skillDTO){
        return Skill.builder()
                .name(skillDTO.getName())
                .level(skillDTO.getLevel())
                .others(skillDTO.getOthers())
                .build();
    }
}