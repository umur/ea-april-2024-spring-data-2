package com.example.lab03.repository;

import com.example.lab03.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //@EntityGraph(value = "product-with-reviews-and-user", type = EntityGraph.EntityGraphType.FETCH)
    //List<Product> findAll();
}