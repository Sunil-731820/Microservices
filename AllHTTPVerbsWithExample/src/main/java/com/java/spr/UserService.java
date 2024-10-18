package com.java.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    
//    Adding the New user to the Database okay 
    @Transactional
    public void addUser(Long id, String firstName, String lastName, String email) {
        userRepository.insertUser(id, firstName, lastName, email);
    }

}
