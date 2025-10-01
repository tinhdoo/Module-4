package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.Category;

import java.util.List;

public interface ICategoryService{
    List<Blog> findByCategoryId(Integer id);

    Object getAllCategories();

    Category getCategoryById(Integer id);
}
