package com.java.spr.api_quick_reference.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "INSERT INTO user (id,first_name, last_name, email, password) VALUES (:id, :firstName, :lastName, :email, :password)", nativeQuery = true)
    void addUser(@Param("id") Long id,
    			 @Param("firstName") String firstName, 
                 @Param("lastName") String lastName, 
                 @Param("email") String email, 
                 @Param("password") String password);
	
	@Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);

}
