package com.tecnocode.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@Getter
@Builder
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
    @Column(name = "adr_id")
    private Integer id;

    @Column(name = "vac_id")
    private Vacancy vacancyId;

    @Column(name = "adr_cep_pczc")
    private String cep;

    @Column(name = "adr_st_name")
    private String street;

    @Column(name = "adr_num")
    private Integer number;

    @Column(name = "adr_detail")
    private String detail;

    @Column(name = "adr_hood")
    private String hood;

    @Column(name = "adr_city")
    private String city;

    @Column(name = "adr_country")
    private String country;

    @Column(name = "adr_others")
    private String others;

    @Column(name = "adr_lat")
    private Integer latitude;

    @Column(name = "adr_long")
    private Integer longitude;

}
