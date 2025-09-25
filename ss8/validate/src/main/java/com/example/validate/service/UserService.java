package com.example.validate.service;

import com.example.validate.model.User;
import com.example.validate.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id).orElse(null);
    }


}
