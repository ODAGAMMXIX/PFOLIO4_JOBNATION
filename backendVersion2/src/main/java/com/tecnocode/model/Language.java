package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @Column(name = "lan_id")
    private Integer id;

    @Column(name = "lan_name")
    private String name;

    @Column(name = "lan_level")
    private String level;
}
