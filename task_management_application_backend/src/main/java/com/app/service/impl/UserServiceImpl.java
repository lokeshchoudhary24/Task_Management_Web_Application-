
package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// Method to register a new user
	@Override
	public User registerUser(User user) {
		// Encode the user's password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	// Method to authenticate and log in a user
	@Override
	public User loginUser(String username, String password) {
		// Retrieve user by username from repository
		User user = userRepository.findByUsername(username);
		// Check if user exists and password matches
		if (user != null && passwordEncoder.matches(password, user.getPassword())) {
			return user; // Return the authenticated user
		} else {
			return null; // Return null if login fails
		}
	}
}