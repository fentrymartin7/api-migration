package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public List<User> getUsers(){
		return userRepo.findAll();
	}
	
	public UserDTO getUserById(int id) throws UserNotFoundException {
		User user = userRepo.findById(id).orElseThrow(UserNotFoundException::new);
		return new UserDTO(user);
	}
	
	public List<User> getUsersByRole(Role role){
		return userRepo.findUsersByRole(role);
	}
	
	@Transactional
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	@Transactional
	public User updateUser(int id,User user) {
		User u = userRepo.findById(id).orElseThrow(UserNotFoundException::new);
		user.setId(u.getId());
		return userRepo.save(user);
	}
	
	@Transactional
	public void deleteUser(int id) throws UserNotFoundException {
		// this tries to retrieve a user by id, if it doesn't exist, throws an exception
		getUserById(id);

		userRepo.deleteById(id);
	}
}
