package miu.edu.Spring.Data2.repository;

import miu.edu.Spring.Data2.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User, Long> {
}
