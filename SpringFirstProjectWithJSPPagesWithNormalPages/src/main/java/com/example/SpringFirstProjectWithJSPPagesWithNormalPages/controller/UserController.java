package com.example.SpringFirstProjectWithJSPPagesWithNormalPages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.model.User;
import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAllUserFromDB(){
		return service.getAllUserfromTheDatabase();
	}

}
