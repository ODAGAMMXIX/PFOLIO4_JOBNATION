package com.tecnocode.payload;

import com.tecnocode.model.*;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CandidateDTO implements Serializable {
    private Address address;

    private Set<Experience> experiences;

    private Set<Qualification> qualifications;

    private Set<Skill> skills;

    private Set<Language> languages;

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
