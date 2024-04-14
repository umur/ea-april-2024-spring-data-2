package com.example.lab03.controller;

import com.example.lab03.entity.Review;
import com.example.lab03.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if(review == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found!");
        return ResponseEntity.ok().body(review);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(id, review);
        if (updatedReview == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update review!");
        }
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
    }

    @GetMapping(params = "product_id")
    public List<Review> getReviewsByProductId(@RequestParam("product_id") Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }
}
