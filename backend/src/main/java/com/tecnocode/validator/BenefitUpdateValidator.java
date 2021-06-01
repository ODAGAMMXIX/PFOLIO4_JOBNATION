package com.tecnocode.validator;

import com.tecnocode.model.Benefit;
import com.tecnocode.repository.BenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class BenefitUpdateValidator implements BenefitValidator {
    private final BenefitRepository benefitRepository;

    @Override
    public void validate(Benefit benefit) {
        if(isNull(benefit.getId())) {
            throw new RuntimeException("O ID do beneficio deverá ser informado.");
        }
        if(!benefitRepository.findById(benefit.getId()).isPresent()) {
            throw new RuntimeException("O beneficio informado para atualizar não existe.");
        }
    }
}
