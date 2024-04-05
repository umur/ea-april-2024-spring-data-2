package spring.data.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.data.lab3.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
