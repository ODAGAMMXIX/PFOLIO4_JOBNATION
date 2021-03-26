package com.tecnocode.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class Company {
    @Id
    @Column(name = "cpy_id")
    private Integer id;

    @ManyToOne
    private Address address;

    @Column(name = "cpy_name" )
    private String name;

    @Column(name = "cpy_cnpj")
    private String cnpj;
}
