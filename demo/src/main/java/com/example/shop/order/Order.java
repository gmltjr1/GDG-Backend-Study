package com.example.shop.order;

import com.example.shop.member.Member;
import com.example.shop.orderProduct.OrderProduct;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    // 주문 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    // 주문자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member customer;

    // 주문 날짜
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    // 주문 테이블
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_product")
    private List<OrderProduct> orderProduct = new ArrayList<>();

    // 총 가격
    @Column(name = "order_price")
    private int orderPrice;

    // 주문자 주소(자동 할당)
    @Column(name = "customer_address")
    private String customerAddress;

    // 주문자 전화번호(자동 할당)
    @Column(name = "custormer_phone")
    private String customerPhone;

    // 주문자 기재 사항
    @Column(name = "order_note", length = 200)
    private String customerNote;

    public Order(Member customer, String customerNote) {
        this.customer = customer;
        this.customerNote = customerNote;

        // 자동
        this.orderDate = LocalDateTime.now();
        this.customerPhone = customer.getPhoneNumber();
        this.customerAddress = customer.getAddress();
    }

    public void AddOrderProduct(OrderProduct orderProduct) {
        this.orderProduct.add(orderProduct);
    }

    public void SetOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
}
