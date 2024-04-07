package com.ea.initializer;

import com.ea.domain.Product;
import com.ea.domain.Review;
import com.ea.domain.User;
import com.ea.repository.ProductRepository;
import com.ea.repository.ReviewRepository;
import com.ea.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private static final Faker FAKER = Faker.instance();
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;


    @Override
    public void run(String... args) {
        // 100 users
        // 1000 products
        // 1000 reviews products

        if(productRepository.count() > 0){
            return;
        }

        System.out.println();
        System.out.println();
        System.out.println("Generating Data");

        List<Product> products = new ArrayList<>();
        List<User> users = new ArrayList<>();


        //Create products
        System.out.println("Generating Products");
        for (int i = 0; i < 1000; i++) {
            Product product = new Product();
            product.setName(FAKER.commerce().productName());
            product.setPrice(Double.parseDouble(FAKER.commerce().price()));
            product.setRating(FAKER.number().randomDigit());
            productRepository.save(product);
            products.add(product);
        }


        //Create Users
        System.out.println("Generating Users");
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername(FAKER.name().username());
            user.setEmail(FAKER.internet().emailAddress());
            user.setPassword(FAKER.crypto().md5());
            userRepository.save(user);
            users.add(user);
        }


        System.out.println("Generating Reviews");
        for (Product product : products) {
            List<Review> reviews = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                Review review = new Review();
                review.setComment(FAKER.lorem().sentence());
                review.setProduct(product);
                final User user = FAKER.options().nextElement(users);
                review.setUser(user);
                reviews.add(review);
            }
            saveProductReviewBatch(reviews);
        }
        System.out.println("Data generation done");
    }


    private static final AtomicInteger counter = new AtomicInteger(0);

    private void saveProductReviewBatch(List<Review> reviews) {

        System.out.println("Saving batch " + counter.incrementAndGet());

        executorService.submit(() -> reviewRepository.saveAll(reviews));
    }
}
