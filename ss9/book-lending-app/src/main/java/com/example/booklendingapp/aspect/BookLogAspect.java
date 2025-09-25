package com.example.booklendingapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BookLogAspect {

    @After(value = " execution( * com.example.booklendingapp.controller.BookController..*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("Hành vi người dùng vừa sử dụng là: "+ joinPoint.getSignature().getName());
    }
}
