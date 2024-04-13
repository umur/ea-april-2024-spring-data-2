package miu.ea.group3g.lab4.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.aop.LogExecutionTime;
import miu.ea.group3g.lab4.entity.*;
import miu.ea.group3g.lab4.service.ProductService;
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

//    @LogExecutionTime
    @GetMapping
    public List<ProductJoin> getAllSelectJoin() {
        List<ProductJoin> products = productService.getAll();
        return products;
    }

//    @LogExecutionTime
    @GetMapping("/selectlazy")
    public List<ProductSelectLazy> getAllSelectLazy() {
        List<ProductSelectLazy> products = productService.getAllSelectLazy();
        return products;
    }

//    @LogExecutionTime
    @GetMapping("/selecteager")
    public List<ProductSelectEager> getAllSelectEager() {
        List<ProductSelectEager> products = productService.getAllSelectEager();
        return products;
    }

//    @LogExecutionTime
    @GetMapping("/subselectlazy")
    public List<ProductSubSelectLazy> getAllSubSelectLazy() {
        List<ProductSubSelectLazy> products = productService.getAllSubSelectLazy();
        return products;
    }

//    @LogExecutionTime
    @GetMapping("/subselecteager")
    public List<ProductSubSelectEager> getAllSubSelectEager() {
        List<ProductSubSelectEager> products = productService.getAllSubSelectEager();
        return products;
    }

//    @LogExecutionTime
    @GetMapping("/batchlazy")
    public List<ProductBatchLazy> getAllBatchLazy() {
        List<ProductBatchLazy> products = productService.getAllBatchLazy();
        return products;
    }

//    @LogExecutionTime
    @GetMapping("/batcheager")
    public List<ProductBatchEager> getAllBatchEager() {
        List<ProductBatchEager> products = productService.getAllBatchEager();
        return products;
    }
}
