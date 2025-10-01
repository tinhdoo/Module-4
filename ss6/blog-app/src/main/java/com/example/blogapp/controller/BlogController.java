package com.example.blogapp.controller;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.entity.Category;
import com.example.blogapp.service.BlogService;
import com.example.blogapp.service.CategoryService;
import com.example.blogapp.service.IBlogService;
import com.example.blogapp.service.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService service;


    private final ICategoryService categoryService;

    public BlogController(BlogService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllBlogs(Model model) {
        model.addAttribute("blogs", service.getAllBlogs());
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "list";
    }


    @PostMapping
    public String saveBlog(@ModelAttribute Blog blog) {
        blog.setDate(LocalDate.now());
        service.saveBlog(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Blog blog = service.getBlogById(id);
        if (blog == null) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "edit";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog) {
        blog.setDate(LocalDate.now());
        service.saveBlog(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Integer id, Model model) {
        Blog blog = service.getBlogById(id);
        if (blog == null) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        return "delete"; // delete.html
    }


    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id) {
        service.deleteBlog(id);
        return "redirect:/blogs";
    }


    @GetMapping("/{id}")
    public String viewBlogDetail(@PathVariable Integer id, Model model) {
        Blog blog = service.getBlogById(id);
        if (blog == null) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        return "detail";
    }

}
