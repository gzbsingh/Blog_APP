package com.Blog_App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_App.models.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {

	List<Comment> findByPostId(int postId);

}
