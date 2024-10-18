package com.java.spr.api_quick_reference.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	 @PostMapping("/register")
	    public String registerUser(@RequestParam Long id,
	    						   @RequestParam String firstName, 
	                               @RequestParam String lastName, 
	                               @RequestParam String email, 
	                               @RequestParam String password) {
		 logger.info("The first name from the COntroler is :="+firstName);
		 logger.info("the last name from the controller is :="+lastName);
		 logger.info("the Email from the Controller is :="+email);
		 logger.info("the password from the controller is :="+password);
	        service.saveUser(id,firstName, lastName, email, password);
	        return "User registered successfully!";
	    }
	 
	 @GetMapping("/email")
	    public User getUserByEmail(@RequestParam String email) {
	        return service.getUserByEmail(email);
	    }


}
