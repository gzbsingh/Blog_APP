package com.Blog_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog_App.models.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>  {

}
