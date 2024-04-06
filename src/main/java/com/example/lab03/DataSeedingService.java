package com.example.lab03;

import com.example.lab03.entity.Product;
import com.example.lab03.entity.Review;
import com.example.lab03.entity.User;
import com.example.lab03.repository.ProductRepository;
import com.example.lab03.repository.ReviewRepository;
import com.example.lab03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DataSeedingService implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {
        if (shouldSeed()) {
            seedUsers(100);
            seedProductsAndReviews(1000, 1000);
        }
    }

    private void seedUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            User user = new User();
            user.setEmail("user" + i + "@example.com");
            user.setPassword("password");
            user.setFirstName("FirstName" + i);
            user.setLastName("LastName" + i);
            users.add(user);
        }
        userRepository.saveAll(users);
    }

    private void seedProductsAndReviews(int productCount, int reviewCountPerProduct) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();

        List<User> users = userRepository.findAll();

        for (int i = 1; i <= productCount; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(random.nextDouble() * 100);
            product.setRating(random.nextDouble() * 5);
            products.add(product);

            Product savedProduct = productRepository.save(product);
            List<Review> reviews = new ArrayList<>();

            for (int j = 1; j <= reviewCountPerProduct; j++) {
                Review review = new Review();
                review.setComment("Review " + j + " for Product " + i);
                review.setProduct(savedProduct);
                User randomUser = users.get(random.nextInt(users.size()));
                review.setUser(randomUser);
                reviews.add(review);
            }

            reviewRepository.saveAll(reviews);
        }
    }

    private boolean shouldSeed() {
        return true;
    }
}
