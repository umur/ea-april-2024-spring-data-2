package com.ea.service;

import com.ea.dto.ReviewDto;
import com.ea.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream().map(
                        review -> {
                            ReviewDto reviewDto = new ReviewDto();
                            reviewDto.setReviewId(review.getId());
                            reviewDto.setReviewerName(review.getUser().getUsername());
                            reviewDto.setComment(review.getComment());
                            reviewDto.setProductId(review.getProduct().getId());
                            reviewDto.setProductName(review.getProduct().getName());
                            return reviewDto;
                        }
                ).toList();
    }
}
