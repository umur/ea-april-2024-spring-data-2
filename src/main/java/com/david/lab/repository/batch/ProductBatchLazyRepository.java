package com.david.lab.repository.batch;

import com.david.lab.model.batch.ProductBatchLazy;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductBatchLazyRepository extends ListCrudRepository<ProductBatchLazy, Long> {
}