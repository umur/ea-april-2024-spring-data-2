package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ProductSubSelectEager;
import miu.ea.group3g.lab4.entity.ProductSubSelectLazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductSubSelectLazyRepository extends JpaRepository<ProductSubSelectLazy, Long> {
}
