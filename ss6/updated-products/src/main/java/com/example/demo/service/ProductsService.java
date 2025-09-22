package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductsNotFoundException;
import com.example.demo.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private IProductsRepository productsRepository;

    // Lấy tất cả sản phẩm
    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    // Tìm sản phẩm theo ID
    public Optional<Product> findById(Integer id) {
        return productsRepository.findById(id);
    }

    // Tìm sản phẩm theo tên (chứa keyword)
 public List<Product> searchByName(String keyword) {
        return productsRepository.findByNameContaining(keyword);
    }


    // Thêm hoặc cập nhật sản phẩm
    public Product save(Product product) {
        return productsRepository.save(product);
    }

    // Xóa sản phẩm theo ID
    public void deleteById(Integer id) {
        productsRepository.deleteById(id);
    }

    // Ví dụ update giá sản phẩm
    public void updatePrice(Integer id, Double price) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new ProductsNotFoundException("Không tìm thấy sản phẩm"));
        product.setPrice(price);
        productsRepository.save(product);
    }


}
