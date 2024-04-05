package miu.ea.group3g.lab4.service;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        System.out.println("**** Start: " + LocalDateTime.now());
        List<User> users = userRepository.findAll();
        System.out.println("**** End: " + LocalDateTime.now());
        return users;
    }
}
