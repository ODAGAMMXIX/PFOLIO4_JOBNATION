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
    private Integer companyId;

    private Integer addressId;

    private String title;

    private String description;

    private Double minSalary;

    private Double maxSalary;

    private LocalDate openDate;

    private LocalDate closeDate;

    private Set<Integer> experiences;

    private Set<Integer> qualifications;

    private Set<Integer> skills;

    private Set<Integer> languages;

    private String contract;

    private Set<Integer> benefits;
}
