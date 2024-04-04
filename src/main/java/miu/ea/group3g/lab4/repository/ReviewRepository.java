package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
