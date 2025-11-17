package com.example.shop.order.service;

import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.order.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {
    Long createOrder(@RequestBody OrderCreateRequest request);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto getOrderById(Long orderId);
    void deleteOrderById(Long orderId);
}
