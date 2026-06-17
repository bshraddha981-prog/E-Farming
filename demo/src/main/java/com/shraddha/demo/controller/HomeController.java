package com.shraddha.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    // Dashboard Page
    @GetMapping("/")
    public String home(HttpSession session) {

        // User login नसेल तर login page वर पाठव
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        // Login असेल तर dashboard दाखव
        return "dashboard";
    }

    // Access Denied Page
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "accessDenied";
    }
}