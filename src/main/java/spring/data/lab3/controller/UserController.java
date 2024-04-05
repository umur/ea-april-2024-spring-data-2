package spring.data.lab3.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import spring.data.lab3.entity.User;
import spring.data.lab3.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/get-users-by-select")
    public ResponseEntity<List<User>> getUsersBySelect() {
        List<User> users = userService.getUsersBySelect();
        return ResponseEntity.ok().body(users);
    }

}
