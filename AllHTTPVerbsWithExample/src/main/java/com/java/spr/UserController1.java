package com.java.spr;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController1 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Logger logger = LoggerFactory.getLogger(UserController1.class);

	// Query to get all users
    @GetMapping("/users")
    public List<Map<String, Object>> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
        return users;
    }
    
//    Query to Create New User 
    
    // Query to create a new user
    @PostMapping("/addUser")
    public String addUser(@RequestBody Map<String, Object> user) {
        String sql = "INSERT INTO users (id,first_name, last_name, email) VALUES (?,?, ?, ?)";
        int result = jdbcTemplate.update(sql, user.get("id"),user.get("first_name"), user.get("last_name"), user.get("email"));
        logger.info("the Value of the Result is :"+result);
        if (result > 0) {
            return "User added successfully.";
        } else {
            return "Failed to add user.";
        }
    }
    
//    retrieve the Single Object using 
    
    @GetMapping("/getSingleobjectUsingSQLQuery")
    public String getSingleObjectUsingSQLQuery() {
    	String sql = "SELECT COUNT(*) FROM users";
    	Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    	logger.info("the Value of the Count is :"+count);
    	return "the Number of the Count is "+count;
    }
    
//    Retrieving the multiple List using Query okay 
    
    @GetMapping("/getMultipleObjectOkay")
    public List<Map<String, Object>> getMultipleListObject() {
    	String sql = "SELECT *FROM users";
    	List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
    	logger.info("the Users is :"+users); 
    	return users;
    }
    
//    get the queryForMap: Retrieves a single row as a Map<String, Object>. 
    
    @GetMapping("/getSingleRowObject")
    public Map<String, Object> getSingleRowObject(){
    	String sql = "SELECT * FROM users WHERE id = ?";
    	Map<String, Object> user = jdbcTemplate.queryForMap(sql,105);
    	logger.info("the Single User is"+user);
    	return user;
    }
}
