package spring.data.lab3.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import spring.data.lab3.entity.Product;
import spring.data.lab3.repository.ProductRepo;

import java.util.List;

@RequiredArgsConstructor
@Service
@Getter
@Setter
public class ProductService {
    private final ProductRepo productRepository;

    public List<Product> getProductsBySelect() {
        // TODO: Implement this method
        var time = System.currentTimeMillis();
        List<Product> products = productRepository.findAll();
        System.out.println(System.currentTimeMillis() - time);
        return products;
    }
}
