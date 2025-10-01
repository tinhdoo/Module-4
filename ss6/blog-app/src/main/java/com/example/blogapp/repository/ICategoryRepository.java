package com.example.blogapp.repository;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByIdCag(Integer idCag);

    List<Category> findByNameCag(String nameCag);
}
