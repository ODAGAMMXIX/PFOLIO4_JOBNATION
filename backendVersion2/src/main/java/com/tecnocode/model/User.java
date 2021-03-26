package com.tecnocode.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter
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
