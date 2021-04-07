package com.tecnocode.payload;

import lombok.*;
import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDTO implements Serializable {
    private String cep;

    private String street;

    private String number;

    private String detail;

    private String hood;

    private String city;

    private String country;

    private String state;
}
