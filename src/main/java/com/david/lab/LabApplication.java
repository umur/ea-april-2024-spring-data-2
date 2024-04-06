package com.david.lab;

import com.david.lab.product.model.ProductBatch;
import com.david.lab.product.model.ProductJoin;
import com.david.lab.product.model.ProductSelect;
import com.david.lab.product.model.ProductSubselect;
import com.david.lab.product.repository.ProductBatchRepository;
import com.david.lab.product.repository.ProductJoinRepository;
import com.david.lab.product.repository.ProductSelectRepository;
import com.david.lab.product.repository.ProductSubselectRepository;
import com.david.lab.review.model.ReviewBatch;
import com.david.lab.review.model.ReviewJoin;
import com.david.lab.review.model.ReviewSelect;
import com.david.lab.review.model.ReviewSubselect;
import com.david.lab.review.repository.ReviewBatchRepository;
import com.david.lab.review.repository.ReviewJoinRepository;
import com.david.lab.review.repository.ReviewSelectRepository;
import com.david.lab.review.repository.ReviewSubselectRepository;
import com.david.lab.user.User;
import com.david.lab.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootApplication
public class LabApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabApplication.class, args);
    }

    // Sample Data Generation
    @Bean
    public CommandLineRunner commandLineRunner(ProductSelectRepository productSelectRepository,
                                               ProductSubselectRepository productSubselectRepository,
                                               ProductJoinRepository productJoinRepository,
                                               ProductBatchRepository productBatchRepository,
                                               UserRepository userRepository,
                                               ReviewSelectRepository reviewSelectRepository,
                                               ReviewSubselectRepository reviewSubselectRepository,
                                               ReviewJoinRepository reviewJoinRepository,
                                               ReviewBatchRepository reviewBatchRepository) {
        return args -> {
            List<User> users = userRepository.saveAll(LongStream.range(0, 100).mapToObj(i -> new User(i, "First Name", "Last Name", "Email", "Passpord", null)).toList());

            List<ProductSelect> productSelects = productSelectRepository.saveAll(LongStream.range(0, 1000).mapToObj(i -> new ProductSelect(i, "Product Name", BigDecimal.ONE, "Rating", null)).toList());
            List<ProductSubselect> productSubselects = productSubselectRepository.saveAll(LongStream.range(0, 1000).mapToObj(i -> new ProductSubselect(i, "Product Name", BigDecimal.ONE, "Rating", null)).toList());
            List<ProductJoin> productJoins = productJoinRepository.saveAll(LongStream.range(0, 1000).mapToObj(i -> new ProductJoin(i, "Product Name", BigDecimal.ONE, "Rating", null)).toList());
            List<ProductBatch> productBatches = productBatchRepository.saveAll(LongStream.range(0, 1000).mapToObj(i -> new ProductBatch(i, "Product Name", BigDecimal.ONE, "Rating", null)).toList());

            reviewSelectRepository.saveAll(IntStream.range(0, 100_000).mapToObj(i -> new ReviewSelect(i, "Review Comment", productSelects.get(i % 1000), users.get(i % 100))).toList());
            reviewSubselectRepository.saveAll(IntStream.range(0, 100_000).mapToObj(i -> new ReviewSubselect(i, "Review Comment", productSubselects.get(i % 1000), users.get(i % 100))).toList());
            reviewJoinRepository.saveAll(IntStream.range(0, 100_000).mapToObj(i -> new ReviewJoin(i, "Review Comment", productJoins.get(i % 1000), users.get(i % 100))).toList());
            reviewBatchRepository.saveAll(IntStream.range(0, 100_000).mapToObj(i -> new ReviewBatch(i, "Review Comment", productBatches.get(i % 1000), users.get(i % 100))).toList());
        };
    }
}