package com.java.spr.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spr.model.User;
import com.java.spr.repository.UserRepository;
import com.java.spr.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	

	@Override
	public List<User> getAllUsers() {
		logger.info("Calling the get All User Mthod from The Implementation class okay :=");
		List<User> listOfAllUser = repository.findAll();
		if(listOfAllUser.isEmpty()) {
			logger.info("no user Found Is This List okay ");
		}
		return listOfAllUser;
		
	}

	
}
