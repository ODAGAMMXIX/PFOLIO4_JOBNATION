package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vcy_exp_cdt")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class VacancyExperienceCandidate {
    @Column(name = "vcy_id")
    private Vacancy vacancyId;

    @Column(name = "column2")
    private Candidate candidateId;

    @Column(name = "column3")
    private Integer noName;
}
