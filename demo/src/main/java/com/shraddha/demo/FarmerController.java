package com.shraddha.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farmers")
public class FarmerController {

    private List<String> farmers = new ArrayList<>();

    @GetMapping
    public List<String> getAllFarmers() {
        return farmers;
    }

    @PostMapping
    public String addFarmer(@RequestParam String name) {
        farmers.add(name);
        return "Farmer added: " + name;
    }

    @DeleteMapping
    public String deleteFarmer(@RequestParam String name) {
        farmers.remove(name);
        return "Farmer removed: " + name;
    }
}