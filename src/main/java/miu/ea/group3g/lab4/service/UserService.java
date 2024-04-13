package miu.ea.group3g.lab4.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        System.out.println("**** Start: " + LocalDateTime.now());
        List<User> users = userRepository.findAll();
        System.out.println("**** End: " + LocalDateTime.now());
        return users;
    }

    public List<User> getByNameContains(String name) {
        log.info("name=" + name);
        System.out.println("**** Start: " + LocalDateTime.now());
        List<User> users = userRepository.findByNameContains(name);
        System.out.println("**** End: " + LocalDateTime.now());
        return users;
    }

    public User getByName(String name) {
        log.info("name=" + name);
        System.out.println("**** Start: " + LocalDateTime.now());
        User user = userRepository.findByName(name);
        System.out.println("**** End: " + LocalDateTime.now());
        return user;
    }
}
