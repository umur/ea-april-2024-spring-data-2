package miu.edu.Spring.Data2.service;

import miu.edu.Spring.Data2.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    Review save(Review review);

    boolean update(long id, Review review);

    void deleteById(long id);
}
