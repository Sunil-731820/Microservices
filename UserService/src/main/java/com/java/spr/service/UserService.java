package com.java.spr.service;

import java.util.List;

import com.java.spr.entities.User;

public interface UserService {
	
//	Create New User 
	
	User saveUser(User user);
	
//	get All user 
	
	List<User> getAllUser();
	
//	get A Single user using userId
	
	User getUser(String userId);
	
//	for Deleting the user using userId
	
	void deleteUser(String userId);

}
