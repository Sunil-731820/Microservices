package com.java.spr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query to get all users from the 'users' table
    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getAllUsers();
    
//    get the Single data using Query okay
    @Query(value = "SELECT * FROM users WHERE id = ?",nativeQuery = true)
    User getSingleData(Long id);
    
//    Adding the new Data to the Database  
    @Modifying
    @Query(value = "INSERT INTO users (id, first_name, last_name, email) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertUser(Long id, String firstName, String lastName, String email);
    
    

}
