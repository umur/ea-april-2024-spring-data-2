package spring.data.lab3.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import spring.data.lab3.entity.Product;
import spring.data.lab3.entity.Review;
import spring.data.lab3.entity.User;
import spring.data.lab3.repository.ProductRepo;
import spring.data.lab3.repository.ReviewRepo;
import spring.data.lab3.repository.UserRepo;
import spring.data.lab3.util.MockDataUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Getter
@Setter
public class MockService {
	private final ProductRepo productRepository;
	private final ReviewRepo reviewRepo;
	private final UserRepo userRepo;


	public void mockAll(int numsUser, int numsProduct, int numsReviews) throws Exception {
		List<User> users = new LinkedList<>();
		for (int i = 0; i < numsUser; i++) {
			users.add(MockDataUtil.mockUser());
		}
		userRepo.saveAll(users);

		List<Product> products = new LinkedList<>();
		for (int i = 0; i < numsProduct; i++) {
			products.add(MockDataUtil.mockProduct());
		}
		productRepository.saveAll(products);

		List<Review> reviews = new LinkedList<>();
		for (int i = 0; i < numsReviews; i++) {
			reviews.add(MockDataUtil.mockReview(users.get(random(numsUser)), products.get(random(numsProduct))));
		}
		reviewRepo.saveAll(reviews);

	}

	private int random(int maxSize) {
		return maxSize / (new Random().nextInt(2, maxSize - 1));
	}
}
