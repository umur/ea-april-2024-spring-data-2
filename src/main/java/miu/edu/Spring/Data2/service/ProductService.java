package miu.edu.Spring.Data2.service;

import miu.edu.Spring.Data2.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product save(Product product);

    boolean update(long id, Product product);

    void deleteById(long id);
}
