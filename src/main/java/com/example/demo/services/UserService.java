package com.example.demo.services;

import com.example.demo.repositories.UserRepository;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user) throws Exception{
        System.out.println("login: " + user.getUsername() + " password: " + user.getPassword());

        Optional<User> optional = userRepository.findByUsername(user.getUsername());
        if (optional.isPresent()){
            User correctUser = optional.get();
            if (correctUser.getPassword().equals(user.getPassword())){
                return correctUser;
            }
        }
        //throw new Exception();
        return new User();
    }
}
