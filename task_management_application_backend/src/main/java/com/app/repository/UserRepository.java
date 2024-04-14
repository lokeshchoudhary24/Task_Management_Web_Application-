package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	// JpaRepository interface for User entity with Long as the ID type

	// Custom method to find a user by username
	User findByUsername(String username);
}
