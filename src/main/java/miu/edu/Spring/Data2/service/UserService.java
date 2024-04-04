package miu.edu.Spring.Data2.service;

import miu.edu.Spring.Data2.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAll();

    User getUser(long id);
    boolean update(long id, User user);
    void delete(long id);
}
