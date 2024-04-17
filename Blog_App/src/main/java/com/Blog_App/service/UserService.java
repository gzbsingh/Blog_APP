package com.Blog_App.service;

import com.Blog_App.dto.LoginDto;

import com.Blog_App.dto.UserDto;
import com.Blog_App.models.User;

public interface UserService {

	User register(User newUser);
	 String login(LoginDto logindto);
	 User getUserById(int userId);

	boolean findByUsernameOrEmail(String username, String email);
}
