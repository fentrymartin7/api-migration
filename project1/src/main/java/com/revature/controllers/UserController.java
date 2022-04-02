package com.revature.controllers; 

import java.util.List;
import java.util.UUID;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	private AuthService authService;
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserController(UserService userService,AuthService authService){
		super();
		this.userService = userService;
		this.authService = authService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers(@RequestHeader(value = "Authorization", required = false) String token){
		// this logic should be handled as a filter
		MDC.put("requestId", UUID.randomUUID().toString());
		// auth logic throws a runtime exception if not verified, better placed as a filter
		authService.verifyAdmin(token);
	
		log.info("users retrieved");
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> postUser(@RequestHeader(value="Authorization",required=false)String token,@RequestBody User user){
		/*-
		 * logic to return appropriate response based on creation success
		 */
		authService.verifyAdmin(token);
		userService.createUser(user);
		return new ResponseEntity<>("UserCreated!", HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable("id") int id, @RequestHeader("Authorization") String token){
		
		if (token == null) {
			log.warn("[insert user info here] tried to access endpoint /users/id");
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

		MDC.put("userToken", token);
		UserDTO user = userService.getUserById(id);
		MDC.clear();
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") int id) {
		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@RequestHeader(value="Authorization",required=false)String token,@PathVariable("id") int id) {
		authService.verifyAdmin(token);
		userService.deleteUser(id);
		return new ResponseEntity<>("User was deleted",HttpStatus.OK);
	}
	
}
