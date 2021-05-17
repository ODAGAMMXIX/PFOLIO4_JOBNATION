package com.tecnocode.converter;

import com.tecnocode.model.Company;
import com.tecnocode.payload.CompanyDTO;
import com.tecnocode.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToCompanyConverter implements Converter<CompanyDTO, Company> {
    private final AddressRepository addressRepository;

    @Override
    public Company convert(CompanyDTO companyDTO){
        return Company.builder()
                .address(addressRepository.findById(companyDTO.getAddressId()).orElse(null))
                .name(companyDTO.getName())
                .cnpj(companyDTO.getCnpj())
                .build();
    }
}
