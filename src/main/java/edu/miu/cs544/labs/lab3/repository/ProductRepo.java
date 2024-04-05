package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
}
