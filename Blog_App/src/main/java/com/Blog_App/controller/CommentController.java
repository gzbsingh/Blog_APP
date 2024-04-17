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

import com.Blog_App.dto.CommentDto;
import com.Blog_App.models.Comment;
import com.Blog_App.models.User;
import com.Blog_App.service.CommentService;
import com.Blog_App.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/comments")
@SecurityRequirement(name="scheme")
public class CommentController {

    private final CommentService commentService;
    private final  UserService userService ;

    @Autowired
    public CommentController(CommentService commentService,UserService userService) {
        this.commentService = commentService;
        this.userService=userService;
    }

    @PostMapping("/post/{postId}")
    public ResponseEntity<Comment> addComment(@PathVariable int postId, @RequestBody CommentDto commentDto, @RequestParam int userId) {
        User user = userService.getUserById(userId); 
        Comment comment = commentService.addComment(postId, commentDto, user);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable int postId) {
        List<Comment> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
       @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable int commentId, @RequestBody CommentDto commentDto) {
        Comment updatedComment = commentService.updateComment(commentId, commentDto);
        return ResponseEntity.ok(updatedComment);
    }
  @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable int commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}