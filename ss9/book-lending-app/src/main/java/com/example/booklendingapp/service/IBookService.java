package com.example.booklendingapp.service;

import com.example.booklendingapp.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<Book> findAll();
    Optional<Book> findById(Integer id);

    void returnBook(String code);

    String borrowBook(Integer id);
}
