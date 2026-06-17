package com.shraddha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shraddha.demo.repository.CropRepository;
import com.shraddha.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CropRepository cropRepository;

    // ADMIN LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {

        return "adminLogin";
    }

    // LOGIN CHECK
    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        if (username.equals("admin")
                && password.equals("admin123")) {

            session.setAttribute("admin", "ADMIN");

            return "redirect:/admin/dashboard";
        }

        model.addAttribute("error",
                "Invalid Username or Password");

        return "adminLogin";
    }

    // ADMIN DASHBOARD
    @GetMapping("/dashboard")
    public String adminDashboard(
            HttpSession session,
            Model model) {

        // LOGIN CHECK
        if (session.getAttribute("admin") == null) {

            return "redirect:/admin/login";
        }

        model.addAttribute(
                "users",
                userRepository.findAll());

        model.addAttribute(
                "crops",
                cropRepository.findAll());

        return "admin-dashboard";
    }

    // DELETE USER
    @GetMapping("/delete-user/{id}")
    public String deleteUser(
            @PathVariable Integer id,
            HttpSession session) {

        if (session.getAttribute("admin") == null) {

            return "redirect:/admin/login";
        }

        userRepository.deleteById(id);

        return "redirect:/admin/dashboard";
    }

    // DELETE CROP
    @GetMapping("/delete-crop/{id}")
    public String deleteCrop(
            @PathVariable Long id,
            HttpSession session) {

        if (session.getAttribute("admin") == null) {

            return "redirect:/admin/login";
        }

        cropRepository.deleteById(id);

        return "redirect:/admin/dashboard";
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/admin/login";
    }
}