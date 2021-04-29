package com.tecnocode.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Getter
@Table(name = "userjn")
public class User implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private Integer id;
	
	@Column(name="name")
	private final String name;
	
	@Column(name="email")
	private final String email;
}
