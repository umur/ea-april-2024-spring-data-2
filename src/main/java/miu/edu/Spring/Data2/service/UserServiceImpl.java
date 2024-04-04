package miu.edu.Spring.Data2.service;

import lombok.RequiredArgsConstructor;
import miu.edu.Spring.Data2.entity.User;
import miu.edu.Spring.Data2.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    @Override
    public User createUser(User user)  {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAll()  {
        return  userRepo.findAll();
    }

    @Override
    public User getUser(long id)  {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public boolean update(long id, User user) {
        User optionalUser = userRepo.findById(id).orElse(null);
        if(optionalUser == null){
            return false;
        }

        optionalUser.setEmail(user.getEmail());
        optionalUser.setFirstname(user.getFirstname());
        optionalUser.setLastname(user.getLastname());
        optionalUser.setPassword(user.getPassword());

        userRepo.save(optionalUser);
        return true;
    }

    @Override
    public void delete(long id)  {
        userRepo.deleteById(id);
    }
}
