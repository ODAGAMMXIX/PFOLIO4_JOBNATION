package com.tecnocode.model;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "address_sequence")
    private Integer id;

    @Column(name = "adr_cep_pczc")
    private String cep;

    @Column(name = "adr_st_name")
    private String street;

    @Column(name = "adr_num")
    private String number;

    @Column(name = "adr_detail")
    private String detail;

    @Column(name = "adr_hood")
    private String hood;

    @Column(name = "adr_city")
    private String city;

    @Column(name = "adr_country")
    private String country;

    @Column(name = "adr_state")
    private String state;

    @Column(name = "adr_lat")
    private Integer latitude;

    @Column(name = "adr_long")
    private Integer longitude;

}
