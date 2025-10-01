package com.example.blogapp.controller;

import com.example.blogapp.dto.BlogDto;
import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.Category;
import com.example.blogapp.service.IBlogService;
import com.example.blogapp.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    private final IBlogService blogService;
    private final ICategoryService categoryService;

    public BlogRestController(IBlogService blogService, ICategoryService categoryService, ICategoryService categoryService1) {
        this.blogService = blogService;
        this.categoryService = categoryService1;
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id) {
        Blog blog = blogService.getBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> getBlogsByCategory(@PathVariable Integer id) {
        List<Blog> blogs = blogService.getBlogsByCategory(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBlog(@Valid @RequestBody BlogDto blogDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Category category = categoryService.getCategoryById(blogDto.getCategoryId());
        if (category == null) {
            return new ResponseEntity<>("Danh mục không tồn tại", HttpStatus.BAD_REQUEST);
        }

        Blog blog = new Blog();
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setAuthor(blogDto.getAuthor());
        blog.setDate(blogDto.getDate());
        blog.setStatus(blogDto.getStatus());
        blog.setCategory(category);

        blogService.saveBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }


}
