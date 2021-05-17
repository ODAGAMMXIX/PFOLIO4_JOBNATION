package com.tecnocode.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "userjn")
public class User implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
}
