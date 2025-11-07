package com.example.demo.order.dto;

import com.example.demo.member.Member;
import com.example.demo.product.Product;
import lombok.Getter;

@Getter
public class OrderCreateRequest {
    public Member customer;
    public Product product;
    public String customerNote;
    public Integer quantity;

    public OrderCreateRequest(Member customer, Product product, String customerNote,  Integer quantity) {
        this.customer = customer;
        this.product = product;
        this.customerNote = customerNote;
        this.quantity = quantity;
    }
}
