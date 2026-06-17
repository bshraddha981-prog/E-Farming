package com.shraddha.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shraddha.demo.model.User;

@Controller
public class RegisterController {

    // 👉 Open Register Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // 👉 Handle Register Form Submission
    @PostMapping("/do-register")
    public String registerUser(@ModelAttribute User user) {

        System.out.println("User Registered: " + user.getUsername());

        // 🔥 later you will save in DB using repository

        return "redirect:/login";
    }
}