package com.example.demo.order;

import com.example.demo.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    // 주문 생성
    @Transactional
    public Long createOrder(@RequestBody OrderCreateRequest request) {
        Order order = new Order(
                request.customer,
                request.product,
                request.customerNote,
                request.quantity
        );
        orderRepository.save(order);

        return order.getOrderId();
    }

    // 전체 주문 조회
    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 개별 주문 조회
    @Transactional(readOnly = true)
    public Order getOrderById(Long orderId) {
        Order order = orderRepository.getById(orderId);

        if (order == null)
            throw new RuntimeException("주문을 찾을 수 없습니다.");

        return order;
    }

    // 주문 삭제
    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
