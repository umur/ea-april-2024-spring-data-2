package miu.ea.group3g.lab4;

import com.fasterxml.jackson.databind.JsonSerializer;
import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.entity.Review;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.repository.ProductRepository;
import miu.ea.group3g.lab4.repository.ReviewRepository;
import miu.ea.group3g.lab4.repository.UserRepository;
import miu.ea.group3g.lab4.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab4Application implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private  final UserService userService;
    private static final int NUM_USERS = 100;
    private static final int NUM_PRODUCTS = 1000;
    private static final int NUM_REVIEWS_PER_PRODUCT = 1000;

    public void run(String... args) throws Exception {
//        List<User> users = userService.getAll();

    }

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

}
