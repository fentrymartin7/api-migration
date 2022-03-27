package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService){
		super();
		this.userService = userService;
	}
	
	@GetMapping 
	public ResponseEntity<List<User>> getAll(@RequestParam(name="role",required=false)String role){
		if(role!=null) {
			return new ResponseEntity<>(userService.getUsersByRole(Role.valueOf(role)),HttpStatus.OK);
		}
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> postUser(@RequestBody User user){
		/*-
		 * logic to return appropriate response based on creation success
		 */
		userService.createUser(user);
		return new ResponseEntity<>("UserCreated!", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<User>> getById(){
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User was deleted",HttpStatus.OK);
	}
	
}
