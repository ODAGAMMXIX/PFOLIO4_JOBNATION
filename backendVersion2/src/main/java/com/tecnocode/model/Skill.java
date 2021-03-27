package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Skill {
    @Id
    @Column(name = "ski_id")
    private Integer id;

    @Column(name = "ski_name")
    private String name;

    @Column(name = "ski_level")
    private String level;

    @Column(name = "ski_others")
    private String others;
}
