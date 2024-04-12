package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
    @Override
    @EntityGraph(value = "Product.reviews", type = EntityGraph.EntityGraphType.LOAD)
    List<Product> findAll();
}
