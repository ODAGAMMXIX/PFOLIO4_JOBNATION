package com.tecnocode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tecnocode.repository.UserSysRepository;

@SpringBootApplication
public class TecnocodeApplication {
	@Autowired
	private static UserSysRepository userSysRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TecnocodeApplication.class, args);
	}
}
