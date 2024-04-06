package com.david.lab.product.repository;

import com.david.lab.product.model.ProductBatch;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductBatchRepository extends ListCrudRepository<ProductBatch, Long> {
}