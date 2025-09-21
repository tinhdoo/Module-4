package com.codegym.repository;

import com.codegym.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {
    private final static List<Product> products = new ArrayList<>();

    public List<Product> showAll(){
        List<Product> productList = BaseRepository.entityManager
                .createQuery("select p from product as p").getResultList();
        return productList;
    }

    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            if (product.getId() == null) {
                // ✅ Thêm mới
                BaseRepository.entityManager.persist(product);
            } else {
                // ✅ Update
                BaseRepository.entityManager.merge(product);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }



    public void delete(Integer id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = BaseRepository.entityManager.find(Product.class, id);
            if (product != null) {
                BaseRepository.entityManager.remove(product);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    public void update(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            BaseRepository.entityManager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
    public List<Product> searchByName(String keyword) {
        return BaseRepository.entityManager
                .createQuery("SELECT p FROM product p WHERE p.name LIKE :kw", Product.class)
                .setParameter("kw", "%" + keyword + "%")
                .getResultList();
    }

}
