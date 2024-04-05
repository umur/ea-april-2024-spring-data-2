package edu.miu.cs544.labs.lab3;

import edu.miu.cs544.labs.lab3.entity.Product;
import edu.miu.cs544.labs.lab3.entity.User;
import edu.miu.cs544.labs.lab3.repository.ProductRepo;
import edu.miu.cs544.labs.lab3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {

        // Seed users
        for (int i = 0; i < 100; i++) {
            User user = new User("user" + i, i * 2);
            userRepo.save(user);
        }

        // Seed products
        for(int i=0; i<1000; i++){
            Product p = new Product("Product "+i , "Product "+i + " description");
            productRepo.save(p);
        }
    }
}
