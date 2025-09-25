package com.example.validate.repository;

import com.example.validate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IUserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
