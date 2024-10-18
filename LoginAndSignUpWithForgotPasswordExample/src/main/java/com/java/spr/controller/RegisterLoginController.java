package com.java.spr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.spr.DTO.UserDTO;
import com.java.spr.DTO.UserLoginDTO;
import com.java.spr.model.PasswordResetToken;
import com.java.spr.model.User;
import com.java.spr.repository.TokenRepository;
import com.java.spr.repository.UserRepository;
import com.java.spr.service.UserDetailsServiceImpl;


@Controller
public class RegisterLoginController {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	TokenRepository tokenRepository;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	Logger logger = LoggerFactory.getLogger(RegisterLoginController.class);

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping("/register")
	public String saveUser(@ModelAttribute UserDTO userDTO) {
		User user = userDetailsService.save(userDTO);
		if (user != null)
			return "redirect:/login";
		else
			return "redirect:/register";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute UserLoginDTO userLoginDTO, Model model) {
		userDetailsService.loadUserByUsername(userLoginDTO.getUsername());
		return "userDashboard";
	}

	@GetMapping("/userDashboard")
	public String showUserDashboardForm() {
		return "userDashboard";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPassword";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassordProcess(@ModelAttribute UserDTO userDTO) {
		String output = "";
		logger.info("callig the forgotPasswordProcesss okay :");
		logger.info("the Email is :="+userDTO.getEmail());
		User user = userRepository.findByEmail(userDTO.getEmail());
		if (user != null) {
			logger.info("Inside the If Block for user :");
			output = userDetailsService.sendEmail(user);
			logger.info("the output of The Text is :"+output);
		}
		if (output.equals("success")) {
			logger.info("Sucees Msg");
			return "redirect:/forgotPassword?success";
		}
		logger.info("Error Login :=");
		return "redirect:/login?error";
	}

	@GetMapping("/resetPassword/{token}")
	public String resetPasswordForm(@PathVariable String token, Model model) {
		logger.info("calling the resetPassword Token form Methods :=");
		logger.info("The token is : ="+token);
		PasswordResetToken reset = tokenRepository.findByToken(token);
		if (reset != null && userDetailsService.hasExipred(reset.getExpiryDateTime())) {
			logger.info("Inside the If Block for ResetPasswordform Methods :=");
			model.addAttribute("email", reset.getUser().getEmail());
			return "resetPassword";
		}
		return "redirect:/forgotPassword?error";
	}
	
	@PostMapping("/resetPassword")
	public String passwordResetProcess(@ModelAttribute UserDTO userDTO) {
		User user = userRepository.findByEmail(userDTO.getEmail());
		if(user != null) {
			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			userRepository.save(user);
		}
		return "redirect:/login";
	}

}