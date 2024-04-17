package com.Blog_App.service;

import java.util.List;

import com.Blog_App.dto.CommentDto;
import com.Blog_App.models.Comment;
import com.Blog_App.models.User;

public interface CommentService {
    Comment addComment(int postId, CommentDto commentDto, User user);
    List<Comment> getCommentsByPost(int postId);
    Comment updateComment(int commentId, CommentDto commentDto);
    void deleteComment(int commentId);
}
