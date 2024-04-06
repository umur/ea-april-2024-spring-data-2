package com.Shop.Market.Service;

import com.Shop.Market.Domain.Product;
import com.Shop.Market.dto.ProductDto;
import com.Shop.Market.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream().map(ProductDto::new).toList();
    }
}
