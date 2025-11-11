package com.example.shop.order.dto;

import com.example.shop.member.Member;
import com.example.shop.product.Product;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class OrderCreateRequest {
    public Long customerId;
    public Map<Long, Integer> productQuantity;
    public String customerNote;

    public OrderCreateRequest(Long customerId, Map<Long, Integer> productQuantity, String customerNote,  Integer quantity) {
        this.customerId = customerId;
        this.productQuantity = productQuantity;
        this.customerNote = customerNote;
    }
}
