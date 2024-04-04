package miu.ea.group3g.lab4.service;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.repository.ProductRepository;
import miu.ea.group3g.lab4.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
}
