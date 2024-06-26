package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	// Primary key for the User entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Ensure username is unique in the database
	@Column(unique = true)
	private String username;

	private String password;
}
