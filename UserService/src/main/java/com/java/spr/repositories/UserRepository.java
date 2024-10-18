package com.java.spr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spr.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	

}
