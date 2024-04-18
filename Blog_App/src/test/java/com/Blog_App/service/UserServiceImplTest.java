package com.Blog_App.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Blog_App.models.User;
import com.Blog_App.repository.UserRepository;

public class UserServiceImplTest {

	    @InjectMocks
	    private UserServiceImpl userService;

	    @Mock
	    private UserRepository userRepository;
   
	    @BeforeEach
	    public void setup() {
	    	MockitoAnnotations.openMocks(this);
	    }
	    @Test
	    public void testRegisterUser() {
	     User user=new User();
	     user.setEmail("test@example.com");
	     user.setPassword("testuser");
	     user.setUsername("testuser");
	     	
	        when(userRepository.save(any(User.class))).thenReturn(user);

	        User savedUser = userService.register(user);

	        assertNotNull(savedUser);
	        assertEquals("testuser", savedUser.getUsername());
	        assertEquals("test@example.com", savedUser.getEmail());
	    }

	    @Test
	    public void testGetUserById() {
	        int userId = 1;
	        User user=new User();
	         user.setId(userId);		   
	         user.setEmail("test@example.com");
		     user.setPassword("testuser");
		     user.setUsername("testuser");
	        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

	        User retrievedUser = userService.getUserById(userId);

	        assertNotNull(retrievedUser);
	        assertEquals("testuser", retrievedUser.getUsername());
	        assertEquals("test@example.com", retrievedUser.getEmail());
	    }

	    @Test
	    public void testFindByUsernameOrEmail() {
	        String username = "testuser";
	        String email = "test@example.com";
	        when(userRepository.findByUsernameOrEmail(username, email)).thenReturn(Optional.of(new User()));

	        boolean userExists = userService.findByUsernameOrEmail(username, email);

	        assertTrue(userExists);
	    }
}
