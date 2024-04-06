package edu.miu.cs544.labs.lab3.controller;

import edu.miu.cs544.labs.lab3.annotation.ExecutionTime;
import edu.miu.cs544.labs.lab3.entity.Product;
import edu.miu.cs544.labs.lab3.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Tag(name = "Products", description = "Products API")
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    @ExecutionTime
    public List<Product> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public Product findById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ExecutionTime
    public void save(Product product) {
        service.save(product);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ExecutionTime
    @PutMapping("/")
    public void update(@RequestBody Product product) {
        service.update(product);
    }

}
