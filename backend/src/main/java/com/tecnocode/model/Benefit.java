package com.tecnocode.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "benefits")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Benefit {
    @Id
    @Column(name = "ben_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "benefit_sequence")
    private Integer id;

    @Column(name = "ben_ben")
    private String benefit;
}
