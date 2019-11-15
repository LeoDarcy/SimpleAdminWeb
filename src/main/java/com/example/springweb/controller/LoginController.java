package com.example.springweb.controller;

import com.example.springweb.service.AppService;
import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
    @Autowired
    private HelloService userService;
    private AppService aps;
    public final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String hello(@RequestParam(value = "usrid", required = false) String userid, @RequestParam(value="psw", required = false)String password, Model model ) {
        if(userid != null && password != null){
            ///return "main";
            logger.info("login infor" + userid + password);
            if(userService.CheckByID(userid, password)) {
                model.addAttribute("allapps", aps.getAppsList());
                return "/main";
            }
            else
            {

                return "login";//弹窗*/
            }
        }
        else
            return "login";
    }
}
