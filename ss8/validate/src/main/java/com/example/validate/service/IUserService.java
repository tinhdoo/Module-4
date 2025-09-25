package com.example.validate.service;

import com.example.validate.model.User;
import com.example.validate.repository.IUserRepository;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    User findById(Integer id);
}
