package miu.ea.group3g.lab4.controller;

import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.aop.LogExecutionTime;
import miu.ea.group3g.lab4.entity.User;
import miu.ea.group3g.lab4.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @LogExecutionTime
    @GetMapping
    public List<User> getAll() {
        List<User> users = userService.getAll();
        return users;
    }

    @GetMapping("/contains/{name}")
    public List<User> getByNameContains(@PathVariable String name) {
        return userService.getByNameContains(name);
    }

    @GetMapping("/{name}")
    public User getByName(@PathVariable String name) {
        return userService.getByName(name);
    }
}
