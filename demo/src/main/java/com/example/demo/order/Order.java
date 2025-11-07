package com.example.demo.order;

import com.example.demo.member.Member;
import com.example.demo.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Order {

    // 주문 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    // 주문자
    @ManyToOne(fetch = FetchType.LAZY)
    private Member customer;

    // 주문 날짜
    private LocalDateTime orderDate;

    // 주문 상품
    @ManyToOne(fetch = FetchType.LAZY)
    private Product orderedProduct;

    // 주문 상품 수량
    private Integer quantity;

    // 주문자 주소(자동 할당)
    private String customerAddress;

    // 주문자 전화번호(자동 할당)
    private String customerPhone;

    // 주문자 기재 사항
    private String customerNote;

    public Order(Member customer, Product orderedProduct, String customerNote, Integer quantity) {
        this.customer = customer;
        this.orderedProduct = orderedProduct;
        this.customerNote = customerNote;
        this.quantity = quantity;

        this.orderDate = LocalDateTime.now();
        this.customerPhone = customer.getPhoneNumber();
        this.customerAddress = customer.getAddress();
    }
}
