package com.example.shop.product.service;

import com.example.shop.product.Product;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    Long createProduct(ProductCreateRequest request);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    void updateProduct(Long productId, ProductUpdateRequest request);
    void deleteProduct(Long productId);
}
