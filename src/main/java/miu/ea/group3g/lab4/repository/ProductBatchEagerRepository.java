package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ProductBatchEager;
import miu.ea.group3g.lab4.entity.ProductBatchLazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductBatchEagerRepository extends JpaRepository<ProductBatchEager, Long> {
}
