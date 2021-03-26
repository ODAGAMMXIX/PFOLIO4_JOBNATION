package com.tecnocode.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnocode.model.User;



@Repository
public interface UserSysRepository extends JpaRepository <User, Integer> {
	Optional<User> findByName(String name);
	Optional<User> findByEmail(String email);

}
