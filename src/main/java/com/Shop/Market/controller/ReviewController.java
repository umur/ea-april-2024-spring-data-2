package com.Shop.Market.controller;

import com.Shop.Market.Domain.Review;
import com.Shop.Market.Service.ReviewService;
import com.Shop.Market.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping
    public List<ReviewDto> getAllReviews(){
        return reviewService.getAllReviews();
    }

}
