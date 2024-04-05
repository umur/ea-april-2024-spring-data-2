package spring.data.lab3.util;

import ch.qos.logback.core.testUtil.RandomUtil;
import spring.data.lab3.entity.Product;
import spring.data.lab3.entity.Review;
import spring.data.lab3.entity.User;

import java.util.Random;
import java.util.UUID;

public class MockDataUtil {
	private static Random rand = new Random();

	public static User mockUser() {
		var item = new User();
		item.setName(UUID.randomUUID().toString());
		item.setEmail(rand.nextInt(1000) + "@gmail.com");
		return item;
	}

	public static Product mockProduct() {
		var item = new Product();
		item.setName(UUID.randomUUID().toString());
		item.setPrice(rand.nextDouble(100));
		return item;
	}

	public static Review mockReview(User user, Product product) {
		var item = new Review();
		item.setUser(user);
		item.setProduct(product);
		item.setComment(UUID.randomUUID().toString());
		item.setRating(rand.nextInt(5));
		return item;
	}
}
