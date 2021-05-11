package com.tecnocode.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "candidate_profile")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @Column(name = "cdt_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "candidate_sequence")
    private Integer id;

    @ManyToOne
    private Address address;

    @ManyToMany
    @JoinTable(name = "candidate_experience",
    joinColumns = @JoinColumn(name = "cdt_id"),
    inverseJoinColumns = @JoinColumn(name = "exp_id"))
    private Set<Experience> experiences;

    @ManyToMany
    @JoinTable(name = "candidate_qualification",
    joinColumns = @JoinColumn(name = "cdt_id"),
    inverseJoinColumns = @JoinColumn(name = "qua_id"))
    private Set<Qualification> qualifications;

    @ManyToMany
    @JoinTable(name = "candidate_skill",
    joinColumns = @JoinColumn(name = "cdt_id"),
    inverseJoinColumns = @JoinColumn(name = "ski_id"))
    private Set<Skill> skills;

    @ManyToMany
    @JoinTable(name = "candidate_language",
    joinColumns = @JoinColumn(name = "cdt_id"),
    inverseJoinColumns = @JoinColumn(name = "lan_id"))
    private Set<Language> languages;

    @Column(name = "cdt_cpf")
    private String cpf;

    @Column(name = "cdt_first_name")
    private String firstName;

    @Column(name = "cdt_middle_name")
    private String middleName;

    @Column(name = "cdt_surname")
    private String surname;

    @Column(name = "cdt_gender")
    private String gender;

    @Column(name = "cdt_marital")
    private String marital;

    @Column(name = "cdt_dt_birth")
    private LocalDate birth;

    @Column(name = "cdt_joined")
    private LocalDate joined;

    @Column(name = "cdt_email")
    private String email;

    @Column(name = "cdt_mobile")
    private Integer mobile;

    @Column(name = "cdt_phone")
    private Integer phone;

}
