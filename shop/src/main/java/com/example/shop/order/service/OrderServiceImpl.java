package com.example.shop.order.service;

import com.example.shop.member.service.MemberService;
import com.example.shop.order.Order;
import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.order.dto.OrderResponseDto;
import com.example.shop.order.repository.OrderRepository;
import com.example.shop.orderProduct.OrderProduct;
import com.example.shop.orderProduct.repository.OrderProductRepository;
import com.example.shop.product.Product;
import com.example.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final MemberService memberService;
    private final ProductService productService;

    // 주문 생성
    @Transactional
    @Override
    public Long createOrder(@RequestBody OrderCreateRequest request) {
        Order order = new Order(
                memberService.getMemberById(request.getCustomerId()),
                request.getCustomerNote()
        );

        int price = 0;  // 총 가격 계산
        Map<Long, Integer> productQuantity = request.getProductQuantity();
        for (Map.Entry<Long, Integer> entry : productQuantity.entrySet()) {
            Product product = productService.getProductById(entry.getKey());
            OrderProduct orderProduct = new OrderProduct(order, product, entry.getValue());
            order.AddOrderProduct(orderProduct);
            price += product.getProductPrice() * entry.getValue();
            orderProductRepository.save(orderProduct);
        }
        order.SetOrderPrice(price);

        orderRepository.save(order);

        return order.getOrderId();
    }

    // 전체 주문 조회
    @Transactional(readOnly = true)
    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDto> ords = new ArrayList<>();
        for (Order o : orders) {
            ords.add(getOrderById(o.getOrderId()));
        }

        return ords;
    }

    // 개별 주문 조회
    @Transactional(readOnly = true)
    @Override
    public OrderResponseDto getOrderById(Long orderId) {
        Order order = orderRepository.getById(orderId);

        if (order == null)
            throw new RuntimeException("주문을 찾을 수 없습니다.");

        Map<Long, Integer> productQuantity = new HashMap<>();
        for (OrderProduct op : order.getOrderProduct())
        {
            productQuantity.put(op.getProduct().getProductId(), op.getQuantity());
        }

        return new OrderResponseDto(
                order.getOrderId(),
                order.getCustomer().getId(),
                productQuantity,
                order.getOrderPrice(),
                order.getCustomerAddress(),
                order.getCustomerPhone(),
                order.getCustomerNote()
        );
    }

    // 주문 삭제
    @Transactional
    @Override
    public void deleteOrderById(Long orderId) {
        Order order = orderRepository.getById(orderId);
        for (OrderProduct op : order.getOrderProduct())
        {
            orderProductRepository.deleteById(op.getId());
        }
        orderRepository.deleteById(orderId);
    }
}
