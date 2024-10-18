package com.java.spr.api_quick_reference.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repository;
	Logger logger = LoggerFactory.getLogger(UserService.class);

	//	Create the New user for  
	public void saveUser(Long id ,String firstName, String lastName, String email, String password) {
		logger.info("The first name is : ="+firstName);
		logger.info("the last name is : ="+lastName);
		logger.info("The Email is :="+email);
		logger.info("the password is :="+password);
        repository.addUser(id,firstName, lastName, email, password);
    }
	
//	find user By using Email id : 
	 public User getUserByEmail(String email) {
	        return repository.findByEmail(email);
	    }
	
	

}
