package com.example.demo.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    // 상품id
    private Long ProductId;

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

    /**
     * 상품 생성자
     * id는 repository를 통해 생성할 듯
     */
    public Product(String productName, String productPrice, String productCategory, String productDescription, List<String> productImageUrls) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrls = productImageUrls;
    }

    public void updateInfo(String productName, String productPrice, String productCategory, String productDescription, List<String> productImageUrls) {
        if (productName != null) {
            this.productName = productName;
        }
        if (productPrice != null) {
            this.productPrice = productPrice;
        }
        if (productCategory != null) {
            this.productCategory = productCategory;
        }
        if (productDescription != null) {
            this.productDescription = productDescription;
        }
        if (productImageUrls != null) {
            this.productImageUrls = productImageUrls;
        }
    }

}
