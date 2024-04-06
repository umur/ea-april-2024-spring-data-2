package com.Shop.Market.controller;

import com.Shop.Market.Domain.Product;
import com.Shop.Market.Service.ProductService;
import com.Shop.Market.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public List<ProductDto> getAllProducts(){
        final long startTime = System.currentTimeMillis();
        final List<ProductDto> allProducts = productService.getAllProducts();
        final long endTime = System.currentTimeMillis();
        System.out.println("StartTime is: " + startTime);
        System.out.println("endTime is: " + endTime);
        System.out.println("timeSpent is: " + (endTime - startTime));
        return allProducts;
    }

}
