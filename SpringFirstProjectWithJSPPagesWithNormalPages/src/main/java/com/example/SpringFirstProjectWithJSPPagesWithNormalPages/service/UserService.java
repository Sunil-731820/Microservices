package com.example.SpringFirstProjectWithJSPPagesWithNormalPages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.model.User;
import com.example.SpringFirstProjectWithJSPPagesWithNormalPages.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> getAllUserfromTheDatabase() {
		return repository.findAll();
	}
}
