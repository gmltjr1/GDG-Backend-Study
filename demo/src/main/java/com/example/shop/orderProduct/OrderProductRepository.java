package com.example.shop.orderProduct;

import com.example.shop.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepository {

    @PersistenceContext
    private EntityManager em;

    public OrderProduct getById(Long id) {
        return em.find(OrderProduct.class, id);
    }

    public List<OrderProduct> findAll() {
        return em.createQuery("SELECT op FROM OrderProduct op", OrderProduct.class)
                .getResultList();
    }

    public void save(OrderProduct orderProduct) {
        em.persist(orderProduct);
    }

    public void deleteById(Long id) {
        OrderProduct orderProduct = em.find(OrderProduct.class, id);
        em.remove(orderProduct);
    }
}
