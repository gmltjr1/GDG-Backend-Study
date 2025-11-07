package com.example.demo.product;

import com.example.demo.product.dto.ProductCreateRequest;
import com.example.demo.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // 상품 등록
    @Transactional
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
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 특정 상품 조회
    @Transactional(readOnly = true)
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId);

        if (product == null)
            throw new RuntimeException("상품을 찾을 수 없습니다.");

        return product;
    }

    // 상품 정보 수정
    @Transactional
    public void updateProduct(Long productId, ProductUpdateRequest request) {
        Product product = productRepository.findById(productId);

        if (product == null)
            throw new RuntimeException("상품을 찾을 수 없습니다");

        product.updateInfo(request.getProductName(), request.getProductPrice(), request.getProductCategory(), request.getProductDescription(), request.getProductImageUrls());
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
