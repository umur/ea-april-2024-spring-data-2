package miu.edu.Spring.Data2.repository;

import miu.edu.Spring.Data2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select distinct p from Product p join fetch p.reviews")
    @Override
    List<Product> findAll();
}
