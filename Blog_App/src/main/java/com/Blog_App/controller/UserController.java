package com.Blog_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_App.dto.JwtAuthResponse;
import com.Blog_App.dto.LoginDto;
import com.Blog_App.dto.UserDto;
import com.Blog_App.models.User;
import com.Blog_App.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name="scheme")
@RequestMapping("/api/user")
public class UserController {
  
	 @Autowired
	private UserService userService;
	 
	   @Autowired
	    private PasswordEncoder passwordEncoder;

    // Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = userService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }
    
   

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        // Check if username or email already exists
        if (userService.findByUsernameOrEmail(userDto.getUsername(),userDto.getEmail())) {
            return ResponseEntity.badRequest().body("Username or Email address is already taken!");
        }
      

        // Create a new user entity and set properties from userDto
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setRoles(userDto.getRoles());// Set roles based on userDto (e.g., "ROLE_USER")

        // Save the new user
        User savedUser = userService.register(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
    }
}
