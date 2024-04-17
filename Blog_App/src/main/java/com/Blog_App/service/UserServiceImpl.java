package com.Blog_App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.Blog_App.dto.LoginDto;
import com.Blog_App.dto.UserDto;
import com.Blog_App.models.User;
import com.Blog_App.repository.UserRepository;
import com.Blog_App.security.JwtTokenProvider;
@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	private UserRepository repository;
	
	 @Autowired
	   private AuthenticationManager authenticationManager;

	 @Autowired
	   private JwtTokenProvider jwtTokenProvider;
	
	   @Override
	public User register(User user) {
		
		
		return repository.save(user); 
	}

	@Override
	public String login(LoginDto loginDto) {
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsernameOrEmail(),
	                loginDto.getPassword()
	        ));

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String token = jwtTokenProvider.generateToken(authentication);

	        return token;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return  repository.findById(id).get();
	}

	@Override
	public boolean findByUsernameOrEmail(String username, String email) {
		// TODO Auto-generated method stub
		return repository.findByUsernameOrEmail(username, email).isPresent();
	}



}
