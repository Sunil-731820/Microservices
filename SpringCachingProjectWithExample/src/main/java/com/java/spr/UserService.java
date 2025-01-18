package com.java.spr;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "userCache", key = "#userId")
    public User getUserById(Long userId) {
        // Simulate a delay to demonstrate caching
        try {
            Thread.sleep(2000); // Simulate a slow database call
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return userRepository.findById(userId).orElse(null);
    }
}