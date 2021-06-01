package com.tecnocode.validator;

import com.tecnocode.model.Experience;
import com.tecnocode.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class ExperienceUpdateValidator implements ExperienceValidator {
    private final ExperienceRepository experienceRepository;

    @Override
    public void validate(Experience experience) {
        if(isNull(experience.getId())) {
            throw new RuntimeException("O ID do endereço deverá ser informado.");
        }
        if(!experienceRepository.findById(experience.getId()).isPresent()) {
            throw new RuntimeException("O endereço informado para atualizar não existe.");
        }
    }
}