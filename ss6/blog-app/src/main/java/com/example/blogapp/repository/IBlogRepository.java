package com.example.blogapp.repository;

import com.example.blogapp.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
