package com.java.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spr.model.PasswordResetToken;


public interface TokenRepository extends JpaRepository<PasswordResetToken, Integer>{

	PasswordResetToken findByToken(String token);

}