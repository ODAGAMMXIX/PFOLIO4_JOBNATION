package com.tecnocode.payload;

import com.tecnocode.model.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CandidateDTO implements Serializable {
    private Integer addressId;

    private Set<Integer> experiences;

    private Set<Integer> qualifications;

    private Set<Integer> skills;

    private Set<Integer> languages;

    private String cpf;

    private String firstName;

    private String middleName;

    private String surname;

    private String gender;

    private String marital;

    private LocalDate birth;

    private LocalDate joined;

    private String email;

    private Integer mobile;

    private Integer phone;
}
