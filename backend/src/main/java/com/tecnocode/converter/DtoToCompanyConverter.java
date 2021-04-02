package com.tecnocode.converter;

import com.tecnocode.model.Company;
import com.tecnocode.payload.CompanyDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToCompanyConverter implements Converter<CompanyDTO, Company> {
    @Override
    public Company convert(CompanyDTO companyDTO){
        return Company.builder()
                .address(companyDTO.getAddress())
                .name(companyDTO.getName())
                .build();
    }


}
