package com.seif.users.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seif.users.entities.User;
import com.seif.users.repos.UserRepository;
import com.seif.users.service.UserService;
import com.seif.users.service.register.RegistrationRequest;

@RestController
@CrossOrigin(origins = "*")
public class UserRESTController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRep;
	
	@GetMapping("all")
	public List<User> getAllUsers() {
		return userRep.findAll();
	}
	
	@PostMapping("/register")
	public User register(@RequestBody RegistrationRequest request) {
		return userService.registerUser(request);
	}
	
	@GetMapping("/verifyEmail/{token}")
	public User verifyEmail(@PathVariable("token") String token){
		return userService.validateToken(token);
	}
	
}
