package com.java.spr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
//	using In memory Database for This Kind Of request okay 
	
	
	private Map<Long, User> userDatabase = new HashMap<>();
	 private Long idCounter = 1L;
	 
//	 Save All the database Statically okay 
	 public Map<Long, User> saveAllDataBeforePerformAnyOperationsOkay(){
		 
//		 Saving the First user in map okay 
		 User user1 = new User();
		 user1.setId(idCounter);
		 user1.setFirstName("Sunil");
		 user1.setLastName("Kumar");
		 user1.setEmail("Sunil12@gmail.com");
		 
//		 Saving the Second User data in map Okay 
		 
		 User user2 = new User();
		 user2.setId(idCounter++);
		 user2.setFirstName("Harish");
		 user2.setLastName("Kumar");
		 user2.setEmail("harish11@gmail.com");
		 
//		 Saving the third User data in map okay 
		 
		 User user3 = new User();
		 user3.setId(idCounter++);
		 user3.setFirstName("Sai");
		 user3.setLastName("Pravven");
		 user3.setEmail("Sai23@gmail.com");
		 userDatabase.put(user1.getId(), user1);
		 userDatabase.put(user2.getId(), user2);
		 userDatabase.put(user3.getId(), user3);
		 
		return userDatabase; 
	 }
	
//	get all the user from The in memory Database 
	
	@GetMapping
	public List<User> getAlluser(){
		saveAllDataBeforePerformAnyOperationsOkay();
		return new ArrayList<>(userDatabase.values());
	}
	
//	get The user by using userId
	
	@GetMapping("/{id}")
	public User getuserById(@PathVariable Long id) {
		return userDatabase.get(id);
	}
	
//	Creating the New user using post mapping request okay 
	@PostMapping
	public User createNewUser(@RequestBody User user) {
		user.setId(idCounter++);
		userDatabase.put(user.getId(), user);
		return user;
	}
	
//	Delete the user using user id 
	
	@DeleteMapping("/{id}")
	public String deleteUserUsingId(@PathVariable Long id) {
		userDatabase.remove(id);
		return "user is Deleted Successfully okay from the database ";
	}
	
	
//	
	
	

}
