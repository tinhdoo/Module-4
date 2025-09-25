package com.example.booklendingapp.repository;

import com.example.booklendingapp.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    Optional<Borrow> findByCode(String code);
}
