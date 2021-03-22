package com.tecnocode.model.entity;



import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class UserSys implements Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;	
	
//	@Override
//	public String toString() {
//		return "Users [id=" + id_user + ", name=" + name_user + ", email=" + email_user + "]";
//	}
	public UserSys(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
