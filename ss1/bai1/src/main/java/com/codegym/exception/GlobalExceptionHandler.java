package com.codegym.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

// ⚡ Thêm dòng này để import ConvertException
import com.codegym.exception.ConvertException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Bắt lỗi nhập chữ
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("error", "Vui lòng nhập số hợp lệ cho USD!");
        return "error"; // trả về error.jsp
    }

    // Bắt lỗi USD âm
    @ExceptionHandler(ConvertException.class)
    public String handleConvertException(ConvertException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error"; // trả về error.jsp
    }
}
