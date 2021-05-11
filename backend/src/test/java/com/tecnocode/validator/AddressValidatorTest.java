package com.tecnocode.validator;

import com.tecnocode.model.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AddressValidatorTest {
    @Autowired
    private Map<Operation, AddressValidator> validator;

    @Test
    public void givenAValidAddressData_whenTryToValidate_thenShouldSuccess() {
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
        assertDoesNotThrow(() -> validator.get(Operation.INSERT).validate(address));
    }

    @Test
    public void givenAnInvalidAddressData_whenTryToValidate_thenThrowsException() {
        Address address1 = Address.builder()
                .cep("")
                .street("Rua dos Geronimos")
                .number("123")
                .detail("Perto do super mercado shibata")
                .hood("Vista Verde")
                .city("Jacarei")
                .country("Brasil")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address1));

        Address address2 = Address.builder()
                .cep("")
                .street("")
                .number("123")
                .detail("Perto do super mercado shibata")
                .hood("Vista Verde")
                .city("Jacarei")
                .country("Brasil")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address2));

        Address address3 = Address.builder()
                .cep("")
                .street("")
                .number("")
                .detail("Perto do super mercado shibata")
                .hood("Vista Verde")
                .city("Jacarei")
                .country("Brasil")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address3));

        Address address4 = Address.builder()
                .cep("")
                .street("")
                .number("")
                .detail("")
                .hood("Vista Verde")
                .city("Jacarei")
                .country("Brasil")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address4));

        Address address5 = Address.builder()
                .cep("")
                .street("")
                .number("")
                .detail("")
                .hood("")
                .city("Jacarei")
                .country("Brasil")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address5));

        Address address6 = Address.builder()
                .cep("")
                .street("")
                .number("")
                .detail("")
                .hood("")
                .city("")
                .country("Brasil")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address6));

        Address address7 = Address.builder()
                .cep("")
                .street("")
                .number("")
                .detail("")
                .hood("")
                .city("")
                .country("")
                .state("São Paulo")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address7));

        Address address8 = Address.builder()
                .cep("")
                .street("")
                .number("")
                .detail("")
                .hood("")
                .city("")
                .country("")
                .state("")
                .build();
        assertThrows(RuntimeException.class, () -> validator.get(Operation.INSERT).validate(address8));
    }
}
