package spring.data.lab3.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.data.lab3.entity.Product;
import spring.data.lab3.repository.ProductRepo;
import spring.data.lab3.service.ProductService;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get-products-by-select")
    public ResponseEntity<List<Product>> getProductsBySelect() {
        List<Product> products = productService.getProductsBySelect();
        return ResponseEntity.ok().body(products);
    }
}
