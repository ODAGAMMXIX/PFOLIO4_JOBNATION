package com.tecnocode.repository;

import com.tecnocode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UserSysRepository extends JpaRepository <User, Integer> {
	Optional<User> findByName(String name);
	Optional<User> findByEmail(String email);

}
