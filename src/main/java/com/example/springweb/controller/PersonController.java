package com.example.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    @RequestMapping("/person")
    public String hello(Model model) {

        return "personpage";
    }
}
