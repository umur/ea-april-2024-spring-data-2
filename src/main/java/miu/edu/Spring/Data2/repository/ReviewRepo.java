package miu.edu.Spring.Data2.repository;

import miu.edu.Spring.Data2.entity.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review,Long> {
}
