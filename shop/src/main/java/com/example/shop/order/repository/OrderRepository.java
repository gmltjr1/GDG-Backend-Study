package com.example.shop.order.repository;

import com.example.shop.order.Order;

import java.util.List;

public interface OrderRepository {
    Order getById(Long id);
    List<Order> findAll();
    void save(Order order);
    void deleteById(Long id);
}
