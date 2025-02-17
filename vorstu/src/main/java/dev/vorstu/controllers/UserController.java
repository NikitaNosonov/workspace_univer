package dev.vorstu.controllers;

import dev.vorstu.dto.User;
import dev.vorstu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:4200/")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser() {
        return userService.getUsers();
    }
    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        Optional<User> user =userService.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public User changeUser(@RequestBody User changingUser) {
        return userService.update(changingUser);
    }

    @DeleteMapping(value="/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
