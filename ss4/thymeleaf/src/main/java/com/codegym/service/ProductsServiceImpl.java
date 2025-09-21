package com.codegym.service;

import com.codegym.entity.Product;
import com.codegym.exception.ProductsNotFoundException;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService {
    private final ProductsRepository repository;

    public ProductsServiceImpl(ProductsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> showAll() {
        return repository.showAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        if (product == null) {
            throw new ProductsNotFoundException("Sản phẩm với ID " + id + " không tồn tại!");
        }
        return product;
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void deleteById(Integer id) {
        Product product = findById(id);
        repository.delete(product.getId());
    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> result = repository.searchByName(keyword);
        if (result.isEmpty()) {
            throw new ProductsNotFoundException("Không tìm thấy sản phẩm nào với từ khóa: " + keyword);
        }
        return result;
    }
}
