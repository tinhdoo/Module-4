package com.example.blogapp.service;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.repository.IBlogRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return repository.findAll();
    }

    public void saveBlog(Blog blog) {
        if (blog == null) {
            throw new IllegalArgumentException("Blog không được null");
        }
        if (blog.getTitle() == null || blog.getTitle().isBlank()) {
            throw new IllegalArgumentException("Tiêu đề không được để trống");
        }
        try {
            repository.save(blog);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Nội dung quá dài hoặc vi phạm ràng buộc dữ liệu", e);
        }
    }

    public Blog getBlogById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID không được null");
        }
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy blog với ID: " + id));
    }

    public void deleteBlog(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID không được null");
        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy blog để xoá với ID: " + id);
        }
        repository.deleteById(id);
    }
    @Override
    public List<Blog> getBlogsByCategory(Integer categoryId) {
        return repository.findByCategoryId(categoryId);
    }
}