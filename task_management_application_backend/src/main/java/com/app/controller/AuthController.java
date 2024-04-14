
package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	// Endpoint for registering a new user
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		User registeredUser = userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
	}

	// Endpoint for user login
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		User authenticatedUser = userService.loginUser(user.getUsername(), user.getPassword());
		if (authenticatedUser != null) {
			return ResponseEntity.ok(authenticatedUser);
		}
		// Return unauthorized status if login fails
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}