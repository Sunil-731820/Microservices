package com.java.spr.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spr.entities.User;
import com.java.spr.exception.ResourceNotFoundException;
import com.java.spr.repositories.UserRepository;
import com.java.spr.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	
	@Override
	public User saveUser(User user) {
		System.out.println("Calling the Save User methods :");
//		While Creating the New User i want that UserId Will be Created By Own Okay 
		String randomUserId = UUID.randomUUID().toString();	
		user.setUserId(randomUserId);
		return repository.save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		System.out.println("calling the get All user method okay : =");
		return repository.findAll();
	}

	@Override
	public User getUser(String userId) {
		System.out.println("calling the get Single User from The Database okay ");
		User user = repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not found for This id"));
		return user;
	}

	@Override
	public void deleteUser(String userId) {
		System.out.println("calling the delete User method okay :");
		repository.deleteById(userId);
	}

	
}
