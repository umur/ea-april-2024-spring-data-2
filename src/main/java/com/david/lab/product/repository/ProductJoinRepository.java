package com.david.lab.product.repository;

import com.david.lab.product.model.ProductJoin;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductJoinRepository extends ListCrudRepository<ProductJoin, Long> {
}