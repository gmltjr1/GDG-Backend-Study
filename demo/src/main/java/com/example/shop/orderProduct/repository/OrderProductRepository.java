package com.example.shop.orderProduct.repository;

import com.example.shop.orderProduct.OrderProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository {
    OrderProduct getById(Long id);
    List<OrderProduct> findAll();
    void save(OrderProduct orderProduct);
    void deleteById(Long id);
}
