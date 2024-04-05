package spring.data.lab3.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.data.lab3.service.ReviewService;

@RequiredArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/get-reviews-by-select")
    public void getReviewsBySelect() {
        reviewService.getReviewsBySelect();
    }
}
