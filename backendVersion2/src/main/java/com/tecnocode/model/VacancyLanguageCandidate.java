package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vcy_lan_cdt")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class VacancyLanguageCandidate {
    @Column(name = "vcy_id")
    private Integer vacancyId;

    @Column(name = "column2")
    private Language languageId;

    @Column(name = "column3")
    private Candidate candidateId;

}
