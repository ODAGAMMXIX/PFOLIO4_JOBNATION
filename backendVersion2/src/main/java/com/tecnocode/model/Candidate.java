package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

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
    private Integer id;

    @Column(name = "add_id")
    private Address addressId;

    @Column(name = "exp_id")
    private Experience experienceId;

    @Column(name = "gra_id")
    private String naoSei;

    @Column(name = "ski_id")
    private Skill skillId;

    @Column(name = "lan_id")
    private Language languageId;

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

    @Column(name = "phone")
    private Integer phone;

}
