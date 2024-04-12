package com.david.lab.repository.join;

import com.david.lab.model.join.ProductJoinLazy;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductJoinLazyRepository extends ListCrudRepository<ProductJoinLazy, Long> {

    @NonNull
    @EntityGraph(value = "ProductJoinLazy.review", type = EntityGraph.EntityGraphType.LOAD)
    List<ProductJoinLazy> findAll();

}