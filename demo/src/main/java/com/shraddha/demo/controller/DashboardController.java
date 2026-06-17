package com.shraddha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shraddha.demo.repository.CropRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {

    @Autowired
    private CropRepository cropRepository;

    // ---------------- DASHBOARD ----------------
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {

        // 🔐 LOGIN CHECK
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        // 📊 GET ALL CROPS (ONLY ONCE ✅)
        var crops = cropRepository.findAll();

        long wheat = crops.stream()
                .filter(c -> "Wheat".equalsIgnoreCase(c.getName()))
                .count();

        long rice = crops.stream()
                .filter(c -> "Rice".equalsIgnoreCase(c.getName()))
                .count();

        long corn = crops.stream()
                .filter(c -> "Corn".equalsIgnoreCase(c.getName()))
                .count();

        // 👉 SEND DATA TO FRONTEND
        model.addAttribute("wheat", wheat);
        model.addAttribute("rice", rice);
        model.addAttribute("corn", corn);

        // 👤 USER INFO
        model.addAttribute("username", session.getAttribute("user"));
        model.addAttribute("role", session.getAttribute("role"));

        // 👑 ROLE BASED DASHBOARD
        String role = (String) session.getAttribute("role");

        if ("ADMIN".equalsIgnoreCase(role)) {
            return "admin-dashboard";
        } else {
            return "user-dashboard";
        }
    }
}