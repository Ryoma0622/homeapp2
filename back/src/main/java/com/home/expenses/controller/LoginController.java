package com.home.expenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }
}
