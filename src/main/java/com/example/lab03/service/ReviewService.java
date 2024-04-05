package com.example.lab03.service;

import com.example.lab03.entity.Review;
import com.example.lab03.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review review) {
        Review existReview = reviewRepository.findById(id).orElse(null);
        if(existReview == null) return null;
        existReview.setComment(review.getComment());
        return reviewRepository.save(existReview);
    }

    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewsByProductId(Long id) {
        return reviewRepository.findByProductId(id);
    }
}
