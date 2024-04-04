package miu.edu.Spring.Data2.service;

import lombok.RequiredArgsConstructor;
import miu.edu.Spring.Data2.entity.Product;
import miu.edu.Spring.Data2.repository.ProductRepo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void deleteById(long id) {
        productRepo.deleteById(id);

    }

    @Override
    public boolean update(long id, Product product) {
        if(productRepo.findById(id).isPresent()){
            Product prod = (Product) productRepo.findById(id).get();
            prod.setName(product.getName());
            prod.setRating(prod.getRating());
            prod.setPrice(prod.getPrice());

            productRepo.save(prod);
            return true;

        }
        else{
            return false;
        }
    }

    @Override
    public Product save(Product product) {
        return (Product) productRepo.save(product);
    }
}
