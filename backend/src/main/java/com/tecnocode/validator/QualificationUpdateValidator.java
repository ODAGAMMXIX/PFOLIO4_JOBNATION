package com.tecnocode.validator;

import com.tecnocode.model.Qualification;
import com.tecnocode.repository.QualificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class QualificationUpdateValidator implements QualificationValidator {
    private final QualificationRepository qualificationRepository;

    @Override
    public void validate(Qualification qualification) {
        if(isNull(qualification.getId())) {
            throw new RuntimeException("O ID da qualificação deverá ser informado.");
        }
        if(!qualificationRepository.findById(qualification.getId()).isPresent()) {
            throw new RuntimeException("A qualificação informada para atualizar não existe.");
        }
    }
}
