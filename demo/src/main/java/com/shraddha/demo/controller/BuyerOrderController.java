package com.shraddha.demo.controller;

import com.shraddha.demo.model.Orders;
import com.shraddha.demo.repository.CropRepository;
import com.shraddha.demo.repository.OrderRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyerOrderController {

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private OrderRepository orderRepository;

    // ---------------- BUYER HOME ----------------
    @GetMapping("/buyer")
    public String buyerHome() {
        return "buyer";
    }

    // ---------------- VIEW CROPS ----------------
    @GetMapping("/buyer/crops")
    public String viewCrops(Model model) {
        model.addAttribute("crops", cropRepository.findAll());
        return "buyer-crops";
    }

    // ---------------- BUY CROP ----------------
    @GetMapping("/buy")
    public String buyCrop(@RequestParam String name,
                          @RequestParam double price,
                          HttpSession session) {

        String buyer = (String