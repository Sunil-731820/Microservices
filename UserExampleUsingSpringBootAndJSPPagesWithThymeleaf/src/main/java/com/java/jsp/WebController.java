package com.java.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @GetMapping("/create-user")
    public String showCreateUserPage() {
        return "create-user";
    }

    @PostMapping("/create-user")
    public String createUser(@RequestParam String name, @RequestParam String email) {
        // Call the API to save the user (via UserController's API)
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        
        // Call the backend service to save user (save to DB)
        // You can use RestTemplate here or another method
        // Example: restTemplate.postForObject(apiUrl, newUser, User.class);

        return "redirect:/user-list"; // Redirect to the user list page after saving
    }
}
