package com.example.demo.controllers;

import com.example.demo.services.UserService;
import com.example.demo.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/users/me")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/logout")
    public User logout(){
        return new User();
    }

}
