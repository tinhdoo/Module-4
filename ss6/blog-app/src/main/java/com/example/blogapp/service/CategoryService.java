package com.example.blogapp.service;

import com.example.blogapp.entity.Category;
import com.example.blogapp.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void saveCategory(Category category) {
        repository.save(category);
    }

    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }
}