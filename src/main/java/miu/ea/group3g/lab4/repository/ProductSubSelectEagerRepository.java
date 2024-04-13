package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ProductSelectEager;
import miu.ea.group3g.lab4.entity.ProductSubSelectEager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductSubSelectEagerRepository extends JpaRepository<ProductSubSelectEager, Long> {
}
