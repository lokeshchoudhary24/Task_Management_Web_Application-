package com.app.service.impl;

public interface PasswordEncoder {

	String encode(CharSequence rawPassword);

	boolean matches(CharSequence rawPassword, String encodedPassword);

	boolean matches(String password, String password2);

}
