package com.tecnocode.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "apply")
@Getter
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "apply_sequence", sequenceName = "apply_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vcy_id", referencedColumnName = "vcy_id")
    private Vacancy vacancy;

    @ManyToOne
    @JoinColumn(name = "cdt_id", referencedColumnName = "cdt_id")
    private Candidate candidate;

    @Column(name = "apply_at")
    private LocalDateTime applyAt;
}
