package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ProductJoin;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductJoinRepository extends JpaRepository<ProductJoin, Long> {
    @EntityGraph(value = "Product.reviews")
    List<ProductJoin> findAll();
}
