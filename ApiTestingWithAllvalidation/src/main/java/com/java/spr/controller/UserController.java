package com.java.spr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spr.model.User;
import com.java.spr.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
//	get All the USer Controller method 
	
	@GetMapping
	public List<User> getAlluserokay(){
		return service.getAllUsers();
	}

}
