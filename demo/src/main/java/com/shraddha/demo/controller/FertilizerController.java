package com.shraddha.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shraddha.demo.model.Fertilizer;
import com.shraddha.demo.repository.FertilizerRepository;

@Controller
@RequestMapping("/fertilizer")
public class FertilizerController {

    @Autowired
    private FertilizerRepository fertilizerRepository;

    // 👉 Open fertilizer page
    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("fertilizers", fertilizerRepository.findAll());
        return "fertilizer";
    }

    // 👉 Add fertilizer
    @PostMapping("/add")
    public String addFertilizer(@ModelAttribute Fertilizer fertilizer) {
        fertilizerRepository.save(fertilizer);
        return "redirect:/fertilizer";
    }

    // 👉 DELETE
    @GetMapping("/delete/{id}")
    public String deleteFertilizer(@PathVariable Long id) {
        fertilizerRepository.deleteById(id);
        return "redirect:/fertilizer";
    }

    // 👉 EDIT PAGE OPEN
    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Fertilizer f = fertilizerRepository.findById(id).orElse(null);
        model.addAttribute("fertilizer", f);
        return "editFertilizer";
    }

    // 👉 UPDATE DATA
    @PostMapping("/update")
    public String updateFertilizer(@ModelAttribute Fertilizer fertilizer) {
        fertilizerRepository.save(fertilizer);
        return "redirect:/fertilizer";
    }

    // 👉 RECOMMENDATION (SMART LOGIC 🔥)
    @PostMapping("/recommend")
    public String recommend(@RequestParam String cropName,
                            @RequestParam String soilType,
                            Model model) {

        List<Fertilizer> result =
                fertilizerRepository.findByCropNameAndSoilType(cropName, soilType);

        // 👉 fallback logic
        if (result.isEmpty()) {
            result = fertilizerRepository.findByCropName(cropName);
            model.addAttribute("message", "⚠ Exact match not found, showing similar results");
        }

        model.addAttribute("fertilizers", fertilizerRepository.findAll());
        model.addAttribute("recommendations", result);

        return "fertilizer";
    }
}