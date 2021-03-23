package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "vacancy")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class Vacancy {
    @Id
    @Column(name = "vcy_id")
    private Integer id;

    @Column(name = "cpy_id")
    private Company companyId;

    @Column(name = "usr_id")
    private User userId;

    @Column(name = "adr_id")
    private Address addressId;

    @Column(name = "vcy_title", length = 20)
    private String title;

    @Column(name = "vcy_description", length = 20)
    private String description;

    @Column(name = "vcy_sal_min")
    private Integer minSalary;

    @Column(name = "vcy__sal_max", length = 20)
    private String maxSalary;

    @Column(name = "vcy_openn")
    private LocalDate openDate;

    @Column(name = "vcy_closin")
    private LocalDate closeDate;

    @Column(name = "vcy_exp")
    private LocalDate expiration;

    @Column(name = "vcy_qualif")
    private Qualification qualificationId;

    @Column(name = "vcy_skills")
    private Skill skillId;

    @Column(name = "vcy_languages")
    private Language languageId;

    @Column(name = "vcy_contract", length = 20)
    private Integer contract;

    @Column(name = "vcy_benefits")
    private Benefit benefitId;
}
