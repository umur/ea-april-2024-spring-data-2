package miu.edu.Spring.Data2.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.Spring.Data2.entity.Product;
import miu.edu.Spring.Data2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return  productService.findAll();
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable long id, @RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        productService.deleteById(id);
    }
}
