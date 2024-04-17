package com.Blog_App.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Blog_App.dto.CommentDto;
import com.Blog_App.exception.ResourceNotFoundException;
import com.Blog_App.models.Comment;
import com.Blog_App.models.Post;
import com.Blog_App.models.User;
import com.Blog_App.repository.CommentRepository;
import com.Blog_App.repository.PostRepository;

@Service
public class CommentServiceImpl  implements CommentService{


    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Comment addComment(int postId, CommentDto commentDto, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setPost(post);
        comment.setUser(user);
         comment.setCreatedAt(LocalDateTime.now());
         comment.setUpdatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPost(int postId) {
        return commentRepository.findByPostId(postId);
    }
                                                                  
    @Override
    public Comment updateComment(int commentId, CommentDto commentDto) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        existingComment.setContent(commentDto.getContent());

        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteComment(int commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found"));

        commentRepository.delete(comment);
    }
}
