package miu.ea.group3g.lab4;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.repository.ProductRepository;
import miu.ea.group3g.lab4.repository.ReviewRepository;
import miu.ea.group3g.lab4.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Lab4Application implements CommandLineRunner {

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final ReviewRepository reviewRepository;
	@Override
	public void run(String... args) throws Exception {

	}

	public static void main(String[] args) {
		SpringApplication.run(Lab4Application.class, args);
	}

}
