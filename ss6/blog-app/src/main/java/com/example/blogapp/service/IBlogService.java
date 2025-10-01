package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlogs();
    List<Blog> getBlogsByCategory(Integer categoryId);

    Blog getBlogById(Integer id);

    void saveBlog(Blog blog);

    void deleteBlog(Integer id);
}
