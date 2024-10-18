package com.example.SpringFirstProjectWithJSPPagesWithNormalPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @GetMapping("/users")
    public String getUsers(Model model) {
    	logger.info("calling the getUsers method okay :");
        // Simulating data to be displayed using JSTL
        List<String> users = Arrays.asList("Alice", "Bob", "Charlie","Sunil","Harish");
        logger.info("the SIze of The user is :"+users.size());      
        model.addAttribute("users", users);
        return "users"; // This refers to /WEB-INF/views/users.jsp
    }
}
