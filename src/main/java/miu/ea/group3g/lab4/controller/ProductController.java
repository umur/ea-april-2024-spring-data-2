package miu.ea.group3g.lab4.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.aop.LogExecutionTime;
import miu.ea.group3g.lab4.entity.Product;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.service.ProductService;
import miu.ea.group3g.lab4.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @LogExecutionTime
    @GetMapping
    public List<Product> getAll() {
        System.out.println("Start: " + LocalDateTime.now());
        List<Product> products = productService.getAll();
        System.out.println(" Ended at: " + LocalDateTime.now());
        return products;
    }
}
