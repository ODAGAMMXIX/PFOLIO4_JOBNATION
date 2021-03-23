package com.tecnocode.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "cpy_address_id")
    private Address addressId;

    @Column(name = "cpy_name" )
    private String name;

    @Column(name = "cpy_cnpj")
    private String cnpj;
}
