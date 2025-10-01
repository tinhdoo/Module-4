package com.example.blogapp.controller;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.Category;
import com.example.blogapp.service.BlogService;
import com.example.blogapp.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryService categoryService;
    private final BlogService blogService;

    public CategoryRestController(CategoryService categoryService, BlogService blogService) {
        this.categoryService = categoryService;
        this.blogService = blogService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }



}
