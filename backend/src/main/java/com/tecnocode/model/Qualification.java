package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "qualification")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {
    @Id
    @Column(name = "qua_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "benefit_sequence")
    private Integer id;

    @Column(name = "qua_name")
    private String name;

    @Column(name = "qua_level_degr")
    private String level;

    @Column(name = "qua_institution")
    private String institution;

    @Column(name = "qua_status")
    private String status;

}
