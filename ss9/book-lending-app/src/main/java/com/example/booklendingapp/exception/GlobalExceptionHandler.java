package com.example.booklendingapp.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public String handleBookNotFoundException(BookNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", "Không tìm thấy sách: " + ex.getMessage());
        return "error";
    }

    @ExceptionHandler(CodeNotFoundException.class)
    public String handleCodeNotFoundException(CodeNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", "Mã không tồn tại: " + ex.getMessage());
        return "error";
    }

    @ExceptionHandler(BookUnavailableException.class)
    public String handleBookUnavailableException(BookUnavailableException ex, Model model) {
        model.addAttribute("errorMessage", "Sách đã hết: " + ex.getMessage());
        return "error";
    }
}
