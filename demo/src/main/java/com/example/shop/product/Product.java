package com.example.shop.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "products")
@NoArgsConstructor
public class Product {

    // 상품id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long ProductId;

    // 상품 이름
    @Column(name = "product_name")
    private String productName;

    // 상품 가격
    @Column(name = "product_price")
    private int productPrice;

    // 상품 카테고리
    @Column(name = "product_category")
    private String productCategory;

    // 상품 설명
    @Column(name = "product_description")
    private String productDescription;

    // 상품 이미지
    @Column(name = "product_image_urls")
    private List<String> productImageUrls;

    /**
     * 상품 생성자
     * id는 repository를 통해 생성할 듯
     */
    public Product(String productName, int productPrice, String productCategory, String productDescription, List<String> productImageUrls) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productImageUrls = productImageUrls;
    }

    public void updateInfo(String productName, int productPrice, String productCategory, String productDescription, List<String> productImageUrls) {
        if (productName != null) {
            this.productName = productName;
        }
        if (productPrice != 0) {
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
