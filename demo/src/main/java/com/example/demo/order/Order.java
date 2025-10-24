package com.example.demo.order;

import com.example.demo.member.Member;
import com.example.demo.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Order {

    // 주문 id
    private Long orderId;

    // 주문자
    private Member customer;

    // 주문 날짜
    private LocalDateTime orderDate;

    // 주문 상품
    private Product orderedProduct;

    // 주문자 주소(자동 할당)
    private String customerAddress;

    // 주문자 전화번호(자동 할당)
    private String customerPhone;

    // 주문자 기재 사항
    private String customerNote;

    public Order(Member customer, Product orderedProduct, String customerNote) {
        this.customer = customer;
        this.orderedProduct = orderedProduct;
        this.customerNote = customerNote;

        this.orderDate = LocalDateTime.now();
        this.customerPhone = customer.getPhoneNumber();
        this.customerAddress = customer.getAddress();
    }
}
