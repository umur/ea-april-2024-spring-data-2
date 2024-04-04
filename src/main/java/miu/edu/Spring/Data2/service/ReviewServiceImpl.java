package miu.edu.Spring.Data2.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import miu.edu.Spring.Data2.entity.Review;
import miu.edu.Spring.Data2.repository.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepo reviewRepo;
    @Override
    public List<Review> findAll()  {
        return reviewRepo.findAll();
    }

    @Override
    @Transactional
    public Review save(Review review)  {
        return reviewRepo.save(review);
    }

    @Override
    public boolean update(long id, Review review) {
        if(reviewRepo.findById(id).isPresent()){
            Review rev = (Review) reviewRepo.findById(id).get();
            rev.setComment(review.getComment());
            reviewRepo.save(rev);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void deleteById(long id) {
        reviewRepo.deleteById(id);

    }
}
