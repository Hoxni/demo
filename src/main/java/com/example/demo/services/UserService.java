package com.example.demo.services;

import com.example.demo.repositories.UserRepository;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> login(User user) {
        System.out.println("login: " + user.getUsername() + " password: " + user.getPassword());

        Optional<User> optional = userRepository.findByUsername(user.getUsername());
        if (optional.isPresent()){
            User correctUser = optional.get();
            if (correctUser.getPassword().equals(user.getPassword())){
                return ResponseEntity.ok(correctUser);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(User.newInstance());
    }
}
