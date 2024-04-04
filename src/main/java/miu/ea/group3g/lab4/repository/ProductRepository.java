package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
