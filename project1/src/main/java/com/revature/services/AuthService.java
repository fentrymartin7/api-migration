package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.AuthenticationException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class AuthService {

	private UserRepository userRepo;
	private static Logger log = LoggerFactory.getLogger(AuthService.class);

	@Autowired
	public AuthService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public String register(User user) {
		userRepo.save(user);
		
		log.info("A new user was created");
		return user.getId()+":"+user.getRole().toString();
	}
	
	public String login(String username, String password) {
		User user = userRepo.findUserByUsername(username);
	
		// basic logic to verify that credentials passed in match db credentials
		if(user == null || !user.getPassword().equals(password)) {
			throw new AuthenticationException("Attempted to login with username: " + username);
		}
		
		log.info("User " + user.getUsername() + "'s credentials validated.");
		// return a "token" in the format of [id]:[role]
		return user.getId()+":"+user.getRole().toString();
	}
	
	public void verifyAdmin(String token) {
		// verify that the token passed in is not null
		if(token == null) {
			throw new AuthenticationException("null token");
		}
		
		// basic token is in the format of [id]:[role], split into String[] -> {id, role};
		String[] splitToken = token.split(":");

		// convert the String for the id into an int and query db to retrieve a user, if not found return null
		User principal = userRepo.findById(Integer.valueOf(splitToken[0])).orElse(null);
		
		// Authentication
		if(principal == null || !principal.getRole().toString().equals(splitToken[1]) || !principal.getRole().toString().equals("ADMIN")) {
			throw new AuthenticationException("Unable to verify token of value: " + splitToken[0] + ", " + splitToken[1]);
		} 
		
		log.info("token verified successfully");
		// could log a user id
//		MDC.put("userId", principal.getId());
	}
	
	
}
