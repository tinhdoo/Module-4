package com.example.booklendingapp.controller;

import com.example.booklendingapp.model.Book;
import com.example.booklendingapp.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService service;

    public BookController(IBookService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", service.findAll());
        return "list";
    }

    @GetMapping("/bookDetail/{id}")
    public String getBookById(@PathVariable Integer id, Model model) {
        Book book = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách!"));
        model.addAttribute("book", book);
        return "bookDetail";
    }
    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, Model model) {
        try {
            String code = service.borrowBook(id);
            Book book = new Book();

            model.addAttribute("message", "Mượn sách thành công!");
            model.addAttribute("code", code);
            model.addAttribute("book",book);
            return "borrow";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("borrowCode") String code, Model model) {
        try {
            service.returnBook(code);
            model.addAttribute("successMessage", "Trả sách thành công!");
            return "return";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "return";
        }
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "return";
    }


}
