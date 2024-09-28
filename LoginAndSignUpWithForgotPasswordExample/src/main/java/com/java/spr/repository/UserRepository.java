package com.java.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spr.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}