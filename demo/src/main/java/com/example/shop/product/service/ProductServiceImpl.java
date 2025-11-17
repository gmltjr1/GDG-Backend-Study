package com.example.shop.product.service;

import com.example.shop.product.Product;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import com.example.shop.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    // 상품 등록
    @Transactional
    @Override
    public Long createProduct(ProductCreateRequest request) {
        Product product = new Product(
                request.getProductName(),
                request.getProductPrice(),
                request.getProductCategory(),
                request.getProductDescription(),
                request.getProductImageUrls()
        );

        productRepository.save(product);

        return product.getProductId();
    }

    // 상품 전체 조회
    @Transactional(readOnly = true)
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 특정 상품 조회
    @Transactional(readOnly = true)
    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId);

        if (product == null)
            throw new RuntimeException("상품을 찾을 수 없습니다.");

        return product;
    }

    // 상품 정보 수정
    @Transactional
    @Override
    public void updateProduct(Long productId, ProductUpdateRequest request) {
        Product product = productRepository.findById(productId);

        if (product == null)
            throw new RuntimeException("상품을 찾을 수 없습니다");

        product.updateInfo(request.getProductName(), request.getProductPrice(), request.getProductCategory(), request.getProductDescription(), request.getProductImageUrls());
    }

    // 상품 삭제
    @Transactional
    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
