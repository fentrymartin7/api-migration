package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class AuthService {

	private UserRepository userRepo;

	@Autowired
	public AuthService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public UserDTO login(String username,String password) {
		User principal = userRepo.findUserByUsername(username);
		if(principal == null || !password.equals(principal.getPassword())) {
			return null;
		}
		return new UserDTO(principal);
	}
	
	public String generateToken(UserDTO principal) {
		/*-
		 * fancy logic to create a token
		 * 
		 * This is not a good implementation of a token
		 */
		return principal.getId()+":"+principal.getUsername();
	}
	
	
}
