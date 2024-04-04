package miu.edu.Spring.Data2.repository;

import miu.edu.Spring.Data2.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
}
