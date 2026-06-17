package com.shraddha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shraddha.demo.model.Crop;
import com.shraddha.demo.repository.CropRepository;

@Controller
public class CropController {

    @Autowired
    private CropRepository cropRepository;

    // 👉 Show all crops
    @GetMapping("/crops")
    public String getCrops(Model model) {
        model.addAttribute("crops", cropRepository.findAll());
        return "crop";
    }

    // 👉 Save new crop
    @PostMapping("/addCrop")
    public String addCrop(@ModelAttribute Crop crop) {
        cropRepository.save(crop);
        return "redirect:/crops";
    }

    // 👉 Delete crop (NEXT STEP ready)
    @GetMapping("/deleteCrop/{id}")
    public String deleteCrop(@PathVariable Long id) {
        cropRepository.deleteById(id);
        return "redirect:/crops";
    }

    // 👉 Edit crop (optional next)
    @GetMapping("/editCrop/{id}")
    public String editCrop(@PathVariable Long id, Model model) {
        Crop crop = cropRepository.findById(id).orElse(null);
        model.addAttribute("crop", crop);
        return "editCrop";
    }

    // 👉 Update crop
    @PostMapping("/updateCrop")
    public String updateCrop(@ModelAttribute Crop crop) {
        cropRepository.save(crop);
        return "redirect:/crops";
    }
}