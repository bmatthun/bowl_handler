package com.example.demo.controller;

import com.example.demo.model.Bowl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bowls")
public class BowlController {
    @GetMapping
    public List<Bowl> getAllBowl() {
        return null;
    }
}
