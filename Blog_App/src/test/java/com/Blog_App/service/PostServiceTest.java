package com.Blog_App.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.Blog_App.repository.PostRepository;

public class PostServiceTest {

	@Mock
	PostRepository postRepository;
	
	@InjectMocks
	public PostServiceImpl postService;
	
	
}
