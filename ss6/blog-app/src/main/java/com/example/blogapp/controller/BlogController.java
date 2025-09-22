package com.example.blogapp.controller;

import com.example.blogapp.entity.Blog;
import com.example.blogapp.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllBlogs(Model model) {
        model.addAttribute("blogs", service.getAllBlogs());
        model.addAttribute("blog", new Blog());
        return "list";
    }

    @PostMapping
    public String createBlog(@ModelAttribute Blog blog) {
        blog.setDate(LocalDate.now());
        service.createBlog(blog);
        return "redirect:/blogs";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Blog blog = service.getBlogById(id);
        if (blog == null) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        return "edit";
    }

    // Xử lý cập nhật bài viết
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog) {
        blog.setDate(LocalDate.now()); // hoặc giữ nguyên ngày cũ nếu muốn
        service.createBlog(blog); // save() sẽ update nếu id tồn tại
        return "redirect:/blogs";
    }

    // Hiển thị trang xác nhận xoá
    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Integer id, Model model) {
        Blog blog = service.getBlogById(id);
        if (blog == null) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blog);
        return "delete"; // delete.html
    }


    // Xử lý xoá bài viết
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
