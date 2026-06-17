package com.shraddha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shraddha.demo.service.WeatherService;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {

        String result = weatherService.getWeather(city);

        model.addAttribute("weather", result);
        model.addAttribute("city", city);

        return "weather";
    }
}