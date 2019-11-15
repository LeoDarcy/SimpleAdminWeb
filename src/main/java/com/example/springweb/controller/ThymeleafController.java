package com.example.springweb.controller;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ThymeleafController {
    @Autowired
    HelloService helloService;
    @RequestMapping("/hello")
    public String hello(@RequestParam(name="name", required=false, defaultValue="Bjy") String name, Model model) {
        model.addAttribute("greeting", name);
        List<HelloUser> users = helloService.getUserList();
        model.addAttribute("apps", users);
        return "hello";
    }
}
