package com.codegym.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandle{
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMisMatch(MethodArgumentTypeMismatchException ex, Model model){
        model.addAttribute("error", "Không hợp lệ!");
        return "error";
    }
}
