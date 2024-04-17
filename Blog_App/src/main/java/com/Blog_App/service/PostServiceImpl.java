package com.Blog_App.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Blog_App.dto.PostDto;
import com.Blog_App.exception.ResourceNotFoundException;
import com.Blog_App.models.Category;
import com.Blog_App.models.Post;
import com.Blog_App.models.User;
import com.Blog_App.repository.CategoryRepository;
import com.Blog_App.repository.PostRepository;
import com.Blog_App.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;

	public PostServiceImpl(PostRepository postRepository, UserRepository userRepository,
			CategoryRepository categoryRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

	@Override
	public Post getPostById(int postId) {
		// TODO Auto-generated method stub
		return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
	}

	@Override
	public Post createPost(PostDto postDto, User author) {
		Category category = categoryRepository.findById(postDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCategory(category);
        post.setAuthor(author);
        post.setCreatedAt(LocalDateTime.now());
         post.setUpdatedAt(LocalDateTime.now());
        return postRepository.save(post);
	}

	@Override
	public Post updatePost(int postId, PostDto postDto) {
		 Post existingPost = getPostById(postId);

	        Category category = categoryRepository.findById(postDto.getCategoryId())
	                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

	        existingPost.setTitle(postDto.getTitle());
	        existingPost.setContent(postDto.getContent());
	        existingPost.setCategory(category);

	        return postRepository.save(existingPost);
	}

	@Override
	public void deletePost(int postId) {
		 Post post = getPostById(postId);
	        postRepository.delete(post);

	}

	@Override
	public List<Post> getPostsCreatedByUser(User user) {
		  return postRepository.findByAuthor(user);
	}

	@Override
	public List<Post> getPostsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return postRepository.findByCategoryId(categoryId);
	}

	@Override
	public List<Post> getPostsCreatedToday() {
		// TODO Auto-generated method stub
		 LocalDate today = LocalDate.now();
	        return postRepository.findByCreatedAtBetween(today.atStartOfDay(), today.atTime(23, 59, 59));
	}

}
