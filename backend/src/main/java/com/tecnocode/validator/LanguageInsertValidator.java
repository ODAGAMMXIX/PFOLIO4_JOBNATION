package com.tecnocode.validator;

import com.tecnocode.model.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageInsertValidator implements LanguageValidator{

    @Override
    public void validate(Language language) {
        if (language.getName().isEmpty()) {
            throw new RuntimeException("O idioma não pode estar ser vazio.");
        }
        if (language.getLevel().isEmpty()) {
            throw new RuntimeException("O idioma da lingua não pode ser vazio.");
        }
    }
}
