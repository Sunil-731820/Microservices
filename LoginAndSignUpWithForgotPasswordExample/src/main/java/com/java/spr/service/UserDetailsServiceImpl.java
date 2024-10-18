package com.java.spr.service;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.spr.DTO.UserDTO;
import com.java.spr.model.PasswordResetToken;
import com.java.spr.model.User;
import com.java.spr.repository.TokenRepository;
import com.java.spr.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	UserRepository userRepository;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	TokenRepository tokenRepository;

	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		logger.info("calling the loadUserByUsername Methods okay ");
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new HashSet<GrantedAuthority>());
	}


	public User save(UserDTO userDTO) {
		logger.info("calling the save Methods okay ");
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		return userRepository.save(user);
	}


	public String sendEmail(User user) {
		logger.info("calling the sendEmail Methods okay ");
		try {
			String resetLink = generateResetToken(user);
			logger.info("the resetLink is :"+resetLink);
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("venuspipe929@gmail.com");// input the senders email ID
			logger.info("the user.getEmail() is : ="+user.getEmail());
			msg.setTo(user.getEmail());
			logger.info("the Msg is :="+msg);
			msg.setSubject("Welcome To My Channel");
			msg.setText("Hello \n\n" + "Please click on this link to Reset your Password :" + resetLink + ". \n\n"
					+ "Regards \n" + "ABC");

			javaMailSender.send(msg);
			logger.info("After Mail is Send okay :");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}


	public String generateResetToken(User user) {
		logger.info("calling the generateResetToken Methods okay ");
		UUID uuid = UUID.randomUUID();
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime expiryDateTime = currentDateTime.plusMinutes(30);
		PasswordResetToken resetToken = new PasswordResetToken();
		resetToken.setUser(user);
		resetToken.setToken(uuid.toString());
		resetToken.setExpiryDateTime(expiryDateTime);
		resetToken.setUser(user);
		PasswordResetToken token = tokenRepository.save(resetToken);
		if (token != null) {
			String endpointUrl = "http://localhost:8080/resetPassword";
			return endpointUrl + "/" + resetToken.getToken();
		}
		return "";
	}


	public boolean hasExipred(LocalDateTime expiryDateTime) {
		logger.info("calling the hasExipred Methods okay ");
		LocalDateTime currentDateTime = LocalDateTime.now();
		return expiryDateTime.isAfter(currentDateTime);
	}
}