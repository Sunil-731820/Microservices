package com.java.spr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController3 {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() { 
        return userService.getAllUsers();
    }
    
//    getting the request for new User okay 
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

}
