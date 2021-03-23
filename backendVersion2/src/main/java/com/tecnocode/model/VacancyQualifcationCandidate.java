package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vcy_qua_cdt")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class VacancyQualifcationCandidate {
    @Column(name = "vcy_id")
    private Vacancy vacancyId;

    @Column(name = "qua_id")
    private Integer qualificationId;

    @Column(name = "column3")
    private Integer noName;
}
