package com.example.shop.orderProduct.repository;

import com.example.shop.orderProduct.OrderProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaOrderProductRepository implements OrderProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public OrderProduct getById(Long id) {
        return em.find(OrderProduct.class, id);
    }

    @Override
    public List<OrderProduct> findAll() {
        return em.createQuery("SELECT op FROM OrderProduct op", OrderProduct.class)
                .getResultList();
    }

    @Override
    public void save(OrderProduct orderProduct) {
        em.persist(orderProduct);
    }

    @Override
    public void deleteById(Long id) {
        OrderProduct orderProduct = em.find(OrderProduct.class, id);
        em.remove(orderProduct);
    }
}
