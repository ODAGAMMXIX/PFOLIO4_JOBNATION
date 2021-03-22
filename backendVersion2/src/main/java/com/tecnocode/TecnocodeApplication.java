package com.tecnocode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tecnocode.model.entity.UserSys;
import com.tecnocode.model.repository.UserSysRepository;

@SpringBootApplication
public class TecnocodeApplication {
	@Autowired
	private static UserSysRepository userSysRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TecnocodeApplication.class, args);
	}
}
