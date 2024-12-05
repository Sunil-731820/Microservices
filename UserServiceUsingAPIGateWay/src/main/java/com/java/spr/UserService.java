package com.java.spr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    Logger logger = LoggerFactory.getLogger(UserService.class);

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user details
    public User updateUser(Long id, User userDetails) {
        if (userRepository.existsById(id)) {
            userDetails.setId(id);
            return userRepository.save(userDetails);
        }
        return null;
    }

    // Delete a user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
//    FInding the name using user Name
    
    public User getUserByName(String name) {
    	logger.debug("The value of the Name coming for Service layer is :"+name);
    	return userRepository.findByName(name);
    }
}
