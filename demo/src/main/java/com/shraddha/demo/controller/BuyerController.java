package com.shraddha.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyerController {

    // 👉 Buyer Home Page
    @GetMapping("/buyer")
    public String buyerHome() {
        return "buyer";
    }

    // 👉 View Crops (for buying)
    @GetMapping("/buyer/crops")
    public String viewCrops() {
        return "buyer-crops";
    }

    // 👉 Orders Page
    @GetMapping("/buyer/orders")
    public String orders() {
        return "buyer-orders";
    }
}