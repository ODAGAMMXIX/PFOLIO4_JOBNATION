package com.tecnocode.model.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnocode.model.entity.UserSys;



@Repository
public interface UserSysRepository extends JpaRepository <UserSys, Integer> {
	Optional<UserSys> findByName(String name);
	Optional<UserSys> findByEmail(String email);

}
