package com.example.booklendingapp.repository;

import com.example.booklendingapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
}
