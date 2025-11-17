package com.example.shop.order.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class OrderResponseDto
{
    // 주문 id
    private Long orderId;

    // 주문자 id
    private Long customerId;

    // 상품 id와 개수
    private Map<Long, Integer> productQuantity;

    // 총 가격
    private int orderPrice;

    // 주문자 주소
    private String customerAddress;

    // 주문자 전화번호
    private String customerPhone;

    // 주문자 기재사항
    private String customerNote;

    public OrderResponseDto(Long orderId, Long customerId,  Map<Long, Integer> productQuantity, int orderPrice, String customerAddress, String customerPhone, String customerNote)
    {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productQuantity = productQuantity;
        this.orderPrice = orderPrice;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerNote = customerNote;
    }
}
