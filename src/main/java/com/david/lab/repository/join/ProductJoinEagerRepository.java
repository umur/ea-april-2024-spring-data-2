package com.david.lab.repository.join;

import com.david.lab.model.join.ProductJoinEager;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductJoinEagerRepository extends ListCrudRepository<ProductJoinEager, Long> {

    @NonNull
    @EntityGraph(value = "ProductJoinEager.review", type = EntityGraph.EntityGraphType.LOAD)
    List<ProductJoinEager> findAll();

}