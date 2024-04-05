package miu.ea.group3g.lab4.service;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.repository.ProductRepository;
import miu.ea.group3g.lab4.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
