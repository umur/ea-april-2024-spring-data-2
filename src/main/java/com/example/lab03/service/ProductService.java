package com.example.lab03.service;

import com.example.lab03.entity.Product;
import com.example.lab03.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existProduct = productRepository.findById(id).orElse(null);
        if(existProduct == null) return null;
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setRating(product.getRating());
        return productRepository.save(existProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Fetch using SELECT strategy
    @Transactional
    public Product getProductWithReviewsSelect(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.getReviews().size(); // This will trigger a SELECT for reviews
        }
        return product;
    }
}
