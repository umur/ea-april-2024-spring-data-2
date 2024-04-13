package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ProductSelectLazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductSelectLazyRepository extends JpaRepository<ProductSelectLazy, Long> {
}
