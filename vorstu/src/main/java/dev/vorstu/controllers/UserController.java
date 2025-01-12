package dev.vorstu.controllers;

import dev.vorstu.dto.User;
import dev.vorstu.entity.UserEntity;
import dev.vorstu.repositories.UserRepository;
import dev.vorstu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private final UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User newUser) {
        return userService.create(newUser);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User changeUser(@RequestBody User changingUser) {
        return userService.update(changingUser);
    }

    @DeleteMapping(value="/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserEntity> getAllUsers() {
        System.out.println("Получение всех пользователей");
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден с ID: " + id));
    }
}
