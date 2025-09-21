package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface IProductsService {
    List<Product> showAll();
    void save(Product product);
    Product findById(Integer id);
    void update(Product product);
    void deleteById(Integer id);
    List<Product> searchByName(String keyword);


}
