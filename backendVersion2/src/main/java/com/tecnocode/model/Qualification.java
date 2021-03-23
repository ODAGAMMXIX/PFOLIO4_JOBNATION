package com.tecnocode.model;

import jdk.internal.org.jline.reader.Candidate;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "cdt_id")
    private Candidate candidateId;

    @Column(name = "qua_level_degr")
    private String level;

    @Column(name = "qua_institution")
    private String institution;

    @Column(name = "qua_corse_prg")
    private String couse;

    @Column(name = "qua_start")
    private LocalDate start;

    @Column(name = "qua_end")
    private LocalDate end;

    @Column(name = "qua_status")
    private String status;

}
