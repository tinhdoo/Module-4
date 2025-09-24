package com.example.blogapp.repository;

import com.example.blogapp.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
