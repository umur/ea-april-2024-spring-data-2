package spring.data.lab3.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.data.lab3.entity.Product;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	@Query("select distinct p from Product p join fetch p.reviews")
	List<Product> findAllWithJoin();
}
