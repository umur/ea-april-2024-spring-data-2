package com.Shop.Market;

import com.Shop.Market.Domain.Product;
import com.Shop.Market.Domain.Review;
import com.Shop.Market.Domain.User;
import com.Shop.Market.repository.ProductRepository;
import com.Shop.Market.repository.ReviewRepository;
import com.Shop.Market.repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class SuperMarketApplication implements CommandLineRunner {

    private static final Faker FAKER = Faker.instance();
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SuperMarketApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        // 100 users
        //1000 products
        // 1000 reviews products

        if(productRepository.count() > 0){
            return;
        }

        System.out.println();
        System.out.println();
        System.out.println("Generating Data");

        List<Product> products = new ArrayList<>();
        List<User> users = new ArrayList<>();
//        List<Review> reviews = new ArrayList<>();


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
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUsername(FAKER.name().username());
            user.setEmail(FAKER.internet().emailAddress());
            user.setPasswordHash(FAKER.crypto().md5());
            userRepository.save(user);
            users.add(user);
        }


        System.out.println("Generating Reviews");
        for (Product product : products) {
            for (int i = 0; i < 100; i++) {
                Review review = new Review();
                review.setComment(FAKER.lorem().sentence());
                review.setProduct(product);
                final User user = FAKER.options().nextElement(users);
                review.setUser(user);
                reviewRepository.save(review);
            }
        }
        System.out.println("Data generation done");

    }
}
