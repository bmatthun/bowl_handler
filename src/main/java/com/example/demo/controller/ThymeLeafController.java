package com.example.demo.controller;

import com.example.demo.repository.BowlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@Controller
public class ThymeLeafController {

    @Autowired
    private BowlRepository bowlRepository;

    @GetMapping("/bowls")
    public String listBowl(Model model) {
        model.addAttribute("bowls", bowlRepository.findAll());
        return "bowls/list";
    }
}
