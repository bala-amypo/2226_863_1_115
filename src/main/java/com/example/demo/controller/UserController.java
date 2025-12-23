package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // POST /api/users
    @PostMapping("/")
    public User registerUser(@RequestBody User user) {
        return service.registerUser(user);
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    // GET /api/users
    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}
