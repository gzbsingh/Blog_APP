package com.Blog_App.dto;

import lombok.Data;

@Data
public class JwtAuthResponse {

	 private String accessToken;
	    private String tokenType = "Bearer";
}
