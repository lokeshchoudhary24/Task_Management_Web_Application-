package com.app.service;

import com.app.model.User;

public interface UserService {
	// Interface for UserService

	// Method to register a new user
	User registerUser(User user);

	// Method to authenticate and log in a user
	User loginUser(String username, String password);
}
