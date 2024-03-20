package com.example.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String root() {
        return "redirect:/board/list";
    }

    @GetMapping("/chart")
    public String chart() {
        return "chart";
    }

    @GetMapping("/stock")
    public String stock() {
        return "stock";
    }

    @GetMapping("/tmp")
    public String tmp() {
        return "tmp";
    }
}
