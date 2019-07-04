package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("/login")
    public boolean login(@RequestBody User user){
        System.out.println("login: " + user.getUsername() + " pass: " + user.getPassword());
        return user.getUsername().equals("order_manager") && user.getPassword().equals("pass");
    }

    @GetMapping("/users/me")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody User user){
        userRepository.save(user);
    }
}
