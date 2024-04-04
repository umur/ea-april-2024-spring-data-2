package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.User;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends ListCrudRepository<User, Long> {
    @Fetch(FetchMode.SELECT)
    List<User> getSelectAllByOrderById();

    @Fetch(FetchMode.JOIN)
    List<User> getJoinAllByOrderById();

    @Fetch(FetchMode.SUBSELECT)
    List<User> getSubSelectAllByOrderById();

    @BatchSize(size = 1000)
    List<User> getBatchAllByOrderById();
}
