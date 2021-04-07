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
public class VacancyDTO implements Serializable {
    private Company company;

    private Address address;

    private String title;

    private String description;

    private Double minSalary;

    private Double maxSalary;

    private LocalDate openDate;

    private LocalDate closeDate;

    private Set<Experience> experiences;

    private Set<Qualification> qualifications;

    private Set<Skill> skills;

    private Set<Language> languages;

    private Integer contract;

    private Set<Benefit> benefits;
}
