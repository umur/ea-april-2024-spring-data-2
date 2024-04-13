package miu.ea.group3g.lab4;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.entity.ProductJoin;
import miu.ea.group3g.lab4.entity.ReviewJoin;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.repository.ProductJoinRepository;
import miu.ea.group3g.lab4.repository.ReviewRepository;
import miu.ea.group3g.lab4.repository.UserRepository;
import miu.ea.group3g.lab4.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab4Application implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductJoinRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private static final int NUM_USERS = 100;
    private static final int NUM_PRODUCTS = 1000;
    private static final int NUM_REVIEWS_PER_PRODUCT = 1000;

    public void run(String... args) throws Exception {
        RestTemplate client = new RestTemplate();
        //invoke the first request so that system fully loaded and in operation ready
        client.getForEntity("http://localhost:8080/products/subselectlazy", List.class);

        client.getForEntity("http://localhost:8080/products", List.class);
        client.getForEntity("http://localhost:8080/products/selectlazy", List.class);
        client.getForEntity("http://localhost:8080/products/selectlazy", List.class);
        client.getForEntity("http://localhost:8080/products/subselectlazy", List.class);
        client.getForEntity("http://localhost:8080/products/subselecteager", List.class);
        client.getForEntity("http://localhost:8080/products/batchlazy", List.class);
        client.getForEntity("http://localhost:8080/products/batcheager", List.class);

        /*
        // Populate users
        List<User> users = new ArrayList<>();
        for (int i = 0; i < NUM_USERS; i++) {
            User user = new User();
            user.setName("User " + i);
            users.add(user);
        }
        userRepository.saveAll(users);

        // Populate products and reviews
        Random random = new Random();
        for (int i = 0; i < NUM_PRODUCTS; i++) {
            ProductJoin product = new ProductJoin();
            product.setName("Product " + i);
            product.setPrice(BigDecimal.valueOf(random.nextDouble() * 1000)); // Random price

            List<ReviewJoin> reviews = new ArrayList<>();
            for (int j = 0; j < NUM_REVIEWS_PER_PRODUCT; j++) {
                ReviewJoin review = new ReviewJoin();
                review.setComment("Review " + j + " for product " + i);
                review.setUser(users.get(random.nextInt(NUM_USERS))); // Assign random user
                review.setProduct(product);
                reviews.add(review);
            }

            product.setReviews(reviews);
            productRepository.save(product);

            // Save reviews separately
            reviewRepository.saveAll(reviews);
        }
        */
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

}
