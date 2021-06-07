package com.tecnocode.converter;

import com.tecnocode.model.Company;
import com.tecnocode.model.Distance;
import com.tecnocode.payload.CompanyDTO;
import com.tecnocode.payload.DistanceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToDistanceConverter implements Converter<DistanceDTO, Distance> {
    @Override
    public Distance convert(DistanceDTO distanceDTO){

        Distance distance = new Distance();
        distance.setDestination(distanceDTO.getDestination());
        distance.setOrigin(distanceDTO.getOrigin());

        return distance;

    }
}
