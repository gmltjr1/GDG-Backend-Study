package com.example.shop.order;

import com.example.shop.order.dto.OrderCreateRequest;
import com.example.shop.order.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 주문 생성
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreateRequest request)  {
        Long orderId = orderService.createOrder(request);

        return ResponseEntity.created(URI.create("/orders/" + orderId)).build();
    }

    // 주문 전체 조회
    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {
        List<OrderResponseDto> ords = orderService.getAllOrders();
        return ResponseEntity.ok(ords);
    }

    // 개별 주문 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(
            @PathVariable Long orderId) {
        OrderResponseDto ord = orderService.getOrderById(orderId);
        return ResponseEntity.ok(ord);
    }


    // 주문 취소
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long orderId) {
        orderService.deleteOrderById(orderId);
        return ResponseEntity.noContent().build();
    }
}
