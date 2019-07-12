package com.example.demo.controllers;

import com.example.demo.services.UserService;
import com.example.demo.user.User;
import com.example.demo.repositories.UserRepository;
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
    public User login(@RequestBody User user) throws Exception{
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

    /*@GetMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){
        userRepository.save(user);
    }*/
}
