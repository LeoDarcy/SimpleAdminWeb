package com.example.springweb.controller;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private HelloService userService;
    @RequestMapping("/person")
    public String hello(HttpSession session, Model model) {
        if(session.getAttribute("LoginUserId") == null)
            return "/login";
        String id = (String)session.getAttribute("LoginUserId");
        HelloUser identity = userService.getOne(id);
        model.addAttribute("id", identity.getId());
        model.addAttribute("name", identity.getName());
        model.addAttribute("password", identity.getPassword());
        return "personpage";
    }
    @RequestMapping("/updateperson")
    public String updatePerson(@RequestParam(value = "usrname", required = false) String username, @RequestParam(value="psw", required = false)String password, HttpSession session, Model model){
        Map<String, String> mp = new HashMap<>();
        String id = (String)session.getAttribute("LoginUserId");
        HelloUser usr = userService.getOne(id);
        mp.put("id", id);
        if(username == null)
            mp.put("name", usr.getName());
        else
            mp.put("name", username);
        if(password == null)
            mp.put("password", usr.getPassword());
        else
            mp.put("password", password);
        userService.UpdateByID(mp);
        return "redirect:/person";
    }
}
