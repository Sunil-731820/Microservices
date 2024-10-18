package com.example.SpringFirstProjectWithJSPPagesWithNormalPages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/homePage")
    public String home() {
        return "homePage"; // returns home.jsp
    }

    @GetMapping("/usersPage")
    public String users() {
        return "usersPage"; // returns users.jsp
    }
    
    
    @GetMapping("/aboutPage")
    public String aboutPage() {
    	return "aboutPage";
    }
}