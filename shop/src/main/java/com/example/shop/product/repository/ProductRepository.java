package com.example.shop.product.repository;

import com.example.shop.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void deleteById(Long id);
}
