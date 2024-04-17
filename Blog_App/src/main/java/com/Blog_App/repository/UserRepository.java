package com.Blog_App.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_App.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);
}
