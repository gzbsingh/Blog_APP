package com.Blog_App.service;

import java.util.List;

import com.Blog_App.dto.CategoryDto;
import com.Blog_App.models.Category;

public interface CategoryService {
	List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
    Category createCategory(CategoryDto categoryDto);
    Category updateCategory(int categoryId, CategoryDto categoryDto);
    void deleteCategory(int categoryId);
}
