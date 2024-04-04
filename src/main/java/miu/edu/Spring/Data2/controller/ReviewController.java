package miu.edu.Spring.Data2.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.Spring.Data2.entity.Review;
import miu.edu.Spring.Data2.service.ReviewServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")

public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @PostMapping
    public Review save(@RequestBody Review review){
        return reviewService.save(review);
    }

    @GetMapping
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id, @RequestBody Review review){
        return reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        reviewService.deleteById(id);
    }
}
