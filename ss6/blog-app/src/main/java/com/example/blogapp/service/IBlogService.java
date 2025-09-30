package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlogs();
    List<Blog> getBlogsByCategory(Integer categoryId);

}
