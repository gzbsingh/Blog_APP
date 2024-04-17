package com.Blog_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog_App.dto.CategoryDto;
import com.Blog_App.models.Category;
import com.Blog_App.service.CategoryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@RequestMapping("/api/category")
@SecurityRequirement(name="scheme")
public class CategoryController {

	
	private CategoryService categoryService;
	
		@Autowired
	public CategoryController(CategoryService categoryService) {
		
		this.categoryService = categoryService;
	}


	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
	    List<Category> categories = categoryService.getAllCategories();
	    return ResponseEntity.ok(categories);
	}
	
 @GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
	    Category category = categoryService.getCategoryById(categoryId);
	    return ResponseEntity.ok(category);
	}
   
	 @PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
	    Category category = categoryService.createCategory(categoryDto);
	    return ResponseEntity.ok(category);
	}
  
 @PutMapping("/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
	    Category updatedCategory = categoryService.updateCategory(categoryId, categoryDto);
	    return ResponseEntity.ok(updatedCategory);
	}
  
	 @DeleteMapping("/{categoryId}")
	public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
	    categoryService.deleteCategory(categoryId);
	    return ResponseEntity.ok("Category deleted successfully");
	}
}
