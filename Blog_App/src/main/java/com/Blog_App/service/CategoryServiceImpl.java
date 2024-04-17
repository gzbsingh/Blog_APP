package com.Blog_App.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Blog_App.dto.CategoryDto;
import com.Blog_App.exception.ResourceNotFoundException;
import com.Blog_App.models.Category;
import com.Blog_App.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {

	 private final CategoryRepository categoryRepository;

	    public CategoryServiceImpl(CategoryRepository categoryRepository) {
	        this.categoryRepository = categoryRepository;
	    }

	    @Override
	    public List<Category> getAllCategories() {
	        return categoryRepository.findAll();
	    }

	    @Override
	    public Category getCategoryById(int categoryId) {
	        return categoryRepository.findById(categoryId)
	                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
	    }

	    @Override
	    public Category createCategory(CategoryDto categoryDto) {
	        Category category = new Category();
	        category.setName(categoryDto.getName());

	        return categoryRepository.save(category);
	    }

	    @Override
	    public Category updateCategory(int categoryId, CategoryDto categoryDto) {
	        Category existingCategory = getCategoryById(categoryId);
	        existingCategory.setName(categoryDto.getName());
	       
	        return categoryRepository.save(existingCategory);
	    }

	    @Override
	    public void deleteCategory(int categoryId) {
	        Category category = getCategoryById(categoryId);
	        categoryRepository.delete(category);
	    }

}
