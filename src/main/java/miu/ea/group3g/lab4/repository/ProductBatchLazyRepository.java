package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ProductBatchLazy;
import miu.ea.group3g.lab4.entity.ProductSubSelectLazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductBatchLazyRepository extends JpaRepository<ProductBatchLazy, Long> {
}
