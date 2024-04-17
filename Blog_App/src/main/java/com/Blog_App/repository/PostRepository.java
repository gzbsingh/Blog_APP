package com.Blog_App.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_App.models.Post;
import com.Blog_App.models.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByAuthor(User user);

	List<Post> findByCategoryId(int categoryId);

	List<Post> findByCreatedAtBetween(LocalDateTime atStartOfDay, LocalDateTime atTime);

}
