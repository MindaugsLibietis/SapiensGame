package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/")
    public String start() {
        return "index";
    }
    @GetMapping
    String getPeople(Model model) {
        model.addAttribute("something", "yoo, whats up");
        return "people";
    }
}
