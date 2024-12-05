package com.java.spr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom queries can be added if needed
	
//	Finding the User by using userName
	User findByName(String name);
	
	
}
