package spring.data.lab3.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import spring.data.lab3.entity.User;
import spring.data.lab3.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class UserService {
    private final UserRepo userRepository;

    public List<User> getUsersBySelect() {
//        return userRepository.getAll();
        return userRepository.findAll();
    }
}
