package com.example.demo.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll() {
        return em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public void save(Product product) {
        em.persist(product);
    }

    public void deleteById(Long id){
        Product p = em.find(Product.class, id);
        em.remove(p);
    }
}
