package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.ReviewBatchLazy;
import miu.ea.group3g.lab4.entity.ReviewJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewJoin, Long> {
}
