package edu.miu.cs544.labs.lab3;

import edu.miu.cs544.labs.lab3.entity.User;
import edu.miu.cs544.labs.lab3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {

        // Seed users
        for (int i = 0; i < 100; i++) {
            User user = new User("user" + i, i * 2);
            userRepo.save(user);
        }
    }
}
