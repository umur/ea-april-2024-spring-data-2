package miu.edu.Spring.Data2.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.Spring.Data2.entity.User;
import miu.edu.Spring.Data2.service.UserService;
import miu.edu.Spring.Data2.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@PathVariable long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.delete(id);
    }
}
