package com.Blog_App.dto;



import lombok.Data;

@Data
public class UserDto {

	 private String username;
	    private String email;
	    private String password;
	    private String roles; // Set of roles (e.g., "ROLE_USER")
}
