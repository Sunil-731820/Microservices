package com.java.spr.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spr.entities.User;
import com.java.spr.service.UserService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	private Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
	
//	Creating the controller for new user okay 
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	
//	creating the Method to get All The User from the Database okay 
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = service.getAllUser();
		return ResponseEntity.ok(allUser);
	}
	
//	Creating the method for getting the Single User okay 
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user = service.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
//	This is The Method To Delete The object from  the Database okay 
	
	@DeleteMapping("/{userId}")
	public void deleteUserbyId(@PathVariable String userId) {
		service.deleteUser(userId);
	}

}
