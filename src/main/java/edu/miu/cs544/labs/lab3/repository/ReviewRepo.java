package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.Review;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {

    @Fetch(FetchMode.SELECT)
    List<Review> getSelectAllByOrderById();

    @Fetch(FetchMode.JOIN)
    List<Review> getJoinAllByOrderById();

    @Fetch(FetchMode.SUBSELECT)
    List<Review> getSubSelectAllByOrderById();

    @BatchSize(size = 1000)
    List<Review> getBatchAllByOrderById();
}
