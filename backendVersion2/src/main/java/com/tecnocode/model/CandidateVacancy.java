package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "cdt_vcy")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class CandidateVacancy {
    @Column(name = "column1")
    private Candidate candidateId;

    @Column(name = "column2")
    private Vacancy vacancyId;

    @Column(name = "cvy_date")
    private LocalDate date;
}
