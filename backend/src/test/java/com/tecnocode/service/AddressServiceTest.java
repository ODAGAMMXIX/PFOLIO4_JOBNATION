package com.tecnocode.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecnocode.model.Address;
import com.tecnocode.validator.Operation;

@SpringBootTest
public class AddressServiceTest {
	 @Autowired
	    private AddressService service;

	    @Test
	    public void givenAddress_WhenTryToSaveANewAddress_thenShouldSuccess() {
	    	 Address address = Address.builder()
	                 .cep("12235-625")
	                 .street("Rua dos Geronimos")
	                 .number("123")
	                 .detail("Perto do super mercado shibata")
	                 .hood("Vista Verde")
	                 .city("Jacarei")
	                 .country("Brasil")
	                 .state("São Paulo")
	                 .build();
	    	 final Address savedAddress = service.save(address, Operation.INSERT);
             assertNotNull(savedAddress);
             assertNotNull(savedAddress.getId());
	    }

}
