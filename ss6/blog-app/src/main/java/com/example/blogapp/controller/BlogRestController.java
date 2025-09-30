package com.example.blogapp.controller;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.Category;
import com.example.blogapp.service.BlogService;
import com.example.blogapp.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogRestController {

    private final BlogService blogService;
    private final CategoryService categoryService;

    public BlogRestController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/categories/{categoryId}/blogs")
    public List<Blog> getBlogsByCategory(@PathVariable Integer categoryId) {
        return blogService.getBlogsByCategory(categoryId);
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlogById(@PathVariable Integer id) {
        return blogService.getBlogById(id);
    }
}