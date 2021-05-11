package com.tecnocode.converter;

import com.tecnocode.model.Company;
import com.tecnocode.payload.CompanyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyToDtoConverter implements Converter<Company, CompanyDTO>{
    @Override
    public CompanyDTO convert(Company company){
        return CompanyDTO.builder()
                .address(company.getAddress())
                .name(company.getName())
                .build();
    }
}
