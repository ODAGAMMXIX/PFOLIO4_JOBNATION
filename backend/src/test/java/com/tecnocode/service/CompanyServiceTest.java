package com.tecnocode.service;

import com.tecnocode.model.Address;
import com.tecnocode.model.Company;
import com.tecnocode.validator.Operation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyServiceTest {
    @Autowired
    private CompanyService service;

    @Autowired
    private AddressService addressService;

    @Test
    public void givenCompany_WhenTryToSaveANewCompany_thenShouldSuccess() {
        Company company = Company.builder()
                .name("A CompanyName")
                .cnpj("38354796000153")
                .address(saveNewAddress())
                .build();
        final Company savedCompany = service.save(company, Operation.INSERT);
        assertAll(() -> {
                assertNotNull(savedCompany);
                assertNotNull(savedCompany.getId());
                assertEquals(savedCompany.getId(), 1);
        });
    }

    private Address saveNewAddress() {
        return addressService.save(Address.builder()
                .id(1)
                .cep("12235-625")
                .city("Sao Jose dos Campos")
                .street("Rua Goiania")
                .number("123")
                .hood("Pq Industrial")
                .state("SP")
                .country("Brasil")
                .build(), Operation.INSERT);
    }
}
