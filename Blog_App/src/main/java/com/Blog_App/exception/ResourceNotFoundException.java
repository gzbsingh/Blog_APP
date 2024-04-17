package com.Blog_App.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
