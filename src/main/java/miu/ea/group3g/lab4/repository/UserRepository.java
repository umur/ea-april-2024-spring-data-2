package miu.ea.group3g.lab4.repository;

import miu.ea.group3g.lab4.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @EntityGraph(value = "User.reviews")
    User findByName(String name);

//    @EntityGraph(value = "User.reviews")
    List<User> findByNameContains(String name);

//    @EntityGraph(value = "User.reviews")
//    @Override
    List<User> findAll();
}
