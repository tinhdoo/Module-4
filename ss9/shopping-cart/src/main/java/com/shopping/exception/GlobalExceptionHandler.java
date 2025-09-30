package com.shopping.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    public String handleProductNotFoundException(ProductNotFound ex, Model model) {
        model.addAttribute("errorMessage", "Không tìm thấy sản phẩm: " + ex.getMessage());
        return "error";
    }

}
