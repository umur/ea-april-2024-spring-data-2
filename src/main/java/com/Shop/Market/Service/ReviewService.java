package com.Shop.Market.Service;

import com.Shop.Market.Domain.Review;
import com.Shop.Market.dto.ReviewDto;
import com.Shop.Market.repository.ReviewRepository;
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
