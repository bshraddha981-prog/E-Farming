package com.shraddha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shraddha.demo.model.User;
import com.shraddha.demo.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 👉 ONLY for saving user (NO /register mapping here)
    public void saveUser(User user) {
        user.setRole("FARMER");
        userRepository.save(user);
    }
}