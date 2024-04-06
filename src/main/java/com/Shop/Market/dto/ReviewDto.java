package com.Shop.Market.dto;

import com.Shop.Market.Domain.Review;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewDto {

    private Long reviewId;

    private String comment;

    private String reviewerName;

    private String productName;

    private Long productId;

    public ReviewDto(Review review) {
        reviewId = review.getId();
        comment = review.getComment();
        reviewerName = review.getUser().getUsername();
        productId = review.getProduct().getId();
        productName = review.getProduct().getName();
    }
}
