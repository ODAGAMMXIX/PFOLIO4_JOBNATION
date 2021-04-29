package com.tecnocode.validator;

import com.tecnocode.model.Address;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class AddressInsertValidator implements AddressValidator {

    @Override
    public void validate(Address address) {
        if(!isNull(address.getId())) {
            throw new RuntimeException("O ID do endereço é gerado automaticamente.");
        }
        if(address.getCountry().isEmpty()){
            throw new RuntimeException("O país não pode ser vazio.");
        }
        if(address.getState().isEmpty()){
            throw new RuntimeException("O estado não pode ser vazio.");
        }
        if(address.getCity().isEmpty()){
            throw new RuntimeException("Cidade não pode ser vazio.");
        }
        if(address.getHood().isEmpty()){
            throw new RuntimeException("O bairro não pode ser vazio.");
        }
        if(address.getStreet().isEmpty()){
            throw new RuntimeException("Rua não pode ser vazio.");
        }
        if(address.getNumber().isEmpty()){
            throw new RuntimeException("O número não pode ser vazio.");
        }
        if(address.getCep().isEmpty()){
            throw new RuntimeException("O CEP não pode ser vazio.");
        }
    }
}
