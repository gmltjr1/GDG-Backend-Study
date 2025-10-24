package com.example.demo.product.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductCreateRequest {
    // 상품 이름
    private String productName;

    // 상품 가격
    private String productPrice;

    // 상품 카테고리
    private String productCategory;

    // 상품 설명
    private String productDescription;

    // 상품 이미지
    private List<String> productImageUrls;

    public ProductCreateRequest(String productName, String productPrice, String productCategory, String productDescription, List<String> productImageUrls)
    {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrls = productImageUrls;
    }
}
