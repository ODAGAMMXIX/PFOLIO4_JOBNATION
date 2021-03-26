package com.tecnocode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
    private User user;

    @Column(name = "adr_id")
    private Address address;

    @Column(name = "vcy_title", length = 20)
    private String title;

    @Column(name = "vcy_description", length = 20)
    private String description;

    @Column(name = "vcy_sal_min")
    private Double minSalary;

    @Column(name = "vcy__sal_max", length = 20)
    private Double maxSalary;

    @Column(name = "vcy_openn")
    private LocalDate openDate;

    @Column(name = "vcy_closin")
    private LocalDate closeDate;

    @ManyToMany
    @JoinTable(name = "vacancy_experience",
    joinColumns = @JoinColumn(name = "vcy_id"),
    inverseJoinColumns = @JoinColumn(name = "qexp_id"))
    private Set<Experience> experiences;

    @ManyToMany
    @JoinTable(name = "vacancy_qualification",
    joinColumns = @JoinColumn(name = "vcy_id"),
    inverseJoinColumns = @JoinColumn(name = "qua_id"))
    private Set<Qualification> qualifications;

    @ManyToMany
    @JoinTable(name = "vacancy_skill",
    joinColumns = @JoinColumn(name = "vcy_id"),
    inverseJoinColumns = @JoinColumn(name = "ski_id"))
    private Set<Skill> skills;

    @ManyToMany
    @JoinTable(name = "vacancy_language",
    joinColumns = @JoinColumn(name = "vcy_id"),
    inverseJoinColumns = @JoinColumn(name = "lan_id"))
    private Set<Language> languages;

    @Column(name = "vcy_contract", length = 20)
    private Integer contract;

    @ManyToMany
    @JoinTable(name = "vacancy_benefits",
    joinColumns = @JoinColumn(name = "vcy_id"),
    inverseJoinColumns = @JoinColumn(name = "ben_id"))
    private Set<Benefit> benefits;

}
