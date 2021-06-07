package com.tecnocode.validator;

import com.tecnocode.model.Distance;

import org.springframework.stereotype.Component;

@Component
public class DistanceValidator implements AbstractValidator<Distance> {

    @Override
    public void validate(Distance distance) {
        if (distance.getDestination().isEmpty()) {
            throw new RuntimeException("Destino não pode estar vazio");
        }
        if (distance.getOrigin().isEmpty()) {
            throw new RuntimeException("Origem não pode estar vazio");
        }

    }

}