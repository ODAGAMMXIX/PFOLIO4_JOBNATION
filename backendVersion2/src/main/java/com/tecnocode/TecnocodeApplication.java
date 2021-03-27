package com.tecnocode;

import com.tecnocode.repository.UserSysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TecnocodeApplication {
	@Autowired
	private static UserSysRepository userSysRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TecnocodeApplication.class, args);
	}
}
