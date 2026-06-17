package com.shraddha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shraddha.demo.repository.PestDiseaseRepository;

@Controller
public class PestDiseaseController {

    @Autowired
    private PestDiseaseRepository repository;

    @GetMapping("/pest")
    public String pestPage(Model model) {

        model.addAttribute("list", repository.findAll());

        return "pest";
    }
}