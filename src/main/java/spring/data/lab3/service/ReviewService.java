package spring.data.lab3.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import spring.data.lab3.entity.Review;
import spring.data.lab3.repository.ReviewRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
@Setter
@Getter
public class ReviewService {
    private final ReviewRepo reviewRepository;

    public List<Review> getReviewsBySelect() {
        // TODO: Implement this method
        return reviewRepository.findAll();
    }
}
