package com.Blog_App.service;

import java.util.List;

import com.Blog_App.dto.PostDto;
import com.Blog_App.models.Post;
import com.Blog_App.models.User;

public interface PostService {
	List<Post> getAllPosts();
    Post getPostById(int postId);
    Post createPost(PostDto postDto, User author);
    Post updatePost(int postId, PostDto postDto);
    void deletePost(int postId);
    List<Post> getPostsCreatedByUser(User user);
    List<Post> getPostsByCategory(int categoryId);
    List<Post> getPostsCreatedToday();
}
