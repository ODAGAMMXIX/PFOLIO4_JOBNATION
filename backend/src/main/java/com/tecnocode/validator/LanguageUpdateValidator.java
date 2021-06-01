package com.tecnocode.validator;

import com.tecnocode.model.Language;
import com.tecnocode.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
@Component
@RequiredArgsConstructor
public class LanguageUpdateValidator implements LanguageValidator {
    private final LanguageRepository languageRepository;

    @Override
    public void validate(Language language) {
        if(isNull(language.getId())) {
            throw new RuntimeException("O ID do endereço deverá ser informado.");
        }
        if(!languageRepository.findById(language.getId()).isPresent()) {
            throw new RuntimeException("O endereço informado para atualizar não existe.");
        }
    }
}
