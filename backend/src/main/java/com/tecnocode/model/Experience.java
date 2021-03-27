package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @Column(name = "exp_id")
    private Integer id;

    @Column(name = "exp_company")
    private String company;

    @Column(name = "exp_city")
    private String city;

    @Column(name = "exp_star")
    private LocalDate start;

    @Column(name = "exp_end")
    private LocalDate end;

    @Column(name = "exp_title")
    private String title;

    @Column(name = "exp_achiev")
    private String achiev;
}
