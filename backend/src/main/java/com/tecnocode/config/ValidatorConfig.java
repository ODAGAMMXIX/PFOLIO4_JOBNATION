package com.tecnocode.config;

import com.tecnocode.validator.AddressValidator;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ValidatorConfig {

    @Bean
    public Map<Operation, AddressValidator> addressValidators(
            final @Qualifier("addressInsertValidator") AddressValidator addressInsertValidator,
            final @Qualifier("addressUpdateValidator") AddressValidator addressUpdateValidator) {
        final Map<Operation, AddressValidator> map = new HashMap<>();
        map.put(Operation.INSERT, addressInsertValidator);
        map.put(Operation.UPDATE, addressUpdateValidator);
        return Collections.unmodifiableMap(map);
    }
}
