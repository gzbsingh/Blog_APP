package com.Blog_App.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_App.dto.PostDto;
import com.Blog_App.models.Post;
import com.Blog_App.models.User;
import com.Blog_App.service.PostService;
import com.Blog_App.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/posts")
@SecurityRequirement(name="scheme")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService,UserService userService) {
        this.postService = postService;
		this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto, @RequestParam int userId) {
        User author = userService.getUserById(userId);
        Post post = postService.createPost(postDto, author);
        return ResponseEntity.ok(post);
    }
    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable int postId, @RequestBody PostDto postDto) {
        Post updatedPost = postService.updatePost(postId, postDto);
        return ResponseEntity.ok(updatedPost);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable int postId) {
        Post post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
