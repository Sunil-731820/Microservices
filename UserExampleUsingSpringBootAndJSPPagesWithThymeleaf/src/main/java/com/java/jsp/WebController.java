package com.java.jsp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


@Controller
public class WebController {
	
	@Autowired
    private RestTemplate restTemplate;

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
    
    @GetMapping("/user-list")
    public String getUserList(Model model) {
        // Fetch the list of users via the REST API
        ResponseEntity<List<User>> response = restTemplate.exchange(
                "http://localhost:8080/api/users/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {});
        
        model.addAttribute("users", response.getBody());
        return "user-list";
    }
}
