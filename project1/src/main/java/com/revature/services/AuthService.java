package com.revature.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.AuthenticationException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {

	private UserRepository userRepo;
	private String secretKey = "secretkey";
	
	private static Logger log = LoggerFactory.getLogger(AuthService.class);

	@Autowired
	public AuthService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public String register(User user) {
		
		userRepo.save(user);
		log.info("A new user was created");
		
		Map<String,Object> claims = new HashMap<>();
		claims.put("username", user.getUsername());
		claims.put("role", user.getRole().toString());
		
		JwtBuilder token = Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+60000))
				.setSubject(user.getUsername())
				.signWith(SignatureAlgorithm.HS256, secretKey);
		
        return token.compact();
	}
	
	public String login(String username, String password) {
		User user = userRepo.findUserByUsername(username);
		
		if(user == null || !user.getPassword().equals(password)) {
			throw new AuthenticationException("Invalid login credentials.");
		}
		
		log.info("User " + user.getUsername() + "'s credentials validated.");
		
		Map<String,Object> claims = new HashMap<>();
		claims.put("username", username);
		claims.put("role", user.getRole());
		
		JwtBuilder token = Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+60000))
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS256, secretKey);
		
        return token.compact();
				
	}
	
	public Claims verify(String token) {
		Claims jwt = Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody();
		
		System.out.println(jwt.get("username").toString()+" IS THE USERNAME!!");
		return jwt;
	}
	
}
