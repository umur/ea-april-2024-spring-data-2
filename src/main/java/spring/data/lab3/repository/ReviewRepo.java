package spring.data.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.data.lab3.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
