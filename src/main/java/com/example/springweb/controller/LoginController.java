package com.example.springweb.controller;

import com.example.springweb.dao.AppStruct;
import com.example.springweb.service.AppService;
import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private HelloService userService;
    @Autowired
    private AppService aps;
    public final static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/")
    public String goin()
    {
        return "login";
    }
    @RequestMapping("/index")
    public String goindex()
    {
        return "login";
    }
    @RequestMapping("/login")
    public String hello(@RequestParam(value = "usrid", required = false) String userid,
                        @RequestParam(value="psw", required = false)String password,
                        HttpSession session, Model model ) {
        if(userid != null && password != null){
            ///return "main";
            logger.info("login infor" + userid + password);
            if(userService.CheckByID(userid, password)) {
                List<AppStruct> apps = aps.getAppsList();
                model.addAttribute("apps", apps);
                System.out.println(apps);
                model.addAttribute("test", "this is app test");
                // 设置session
                session.setAttribute("LoginUserId", userid);
                return "redirect:/main";
            }
            else
            {
                return "login";//弹窗
            }
        }
        else
            return "login";
    }
    @RequestMapping("/register")
    public String register(@RequestParam(value = "usrid",required=false) String userid,
                           @RequestParam(value = "usrname",required=false) String username,
                           @RequestParam(value="psw",required=false)String password,
                        HttpSession session, Model model ) {
        if(userid != null && username != null &&password != null){
            ///return "main";
            logger.info("login infor" + userid + password);
            if(userService.CheckByID(userid, password)) {
                return "register";//弹窗
            }
            else if(userService.getOne(userid) == null)
            {
                Map<String, String> mp=new HashMap<String, String>();
                mp.put("id", userid);
                mp.put("name", username);
                mp.put("password", password);
                userService.InsertUser(mp);
                List<AppStruct> apps = aps.getAppsList();
                model.addAttribute("apps", apps);
                System.out.println(apps);
                model.addAttribute("test", "this is app test");
                // 设置session
                session.setAttribute("LoginUserId", userid);
                return "redirect:/main";
            }
            else
                return "register";
        }
        else
            return "register";
    }
    /*@RequestMapping(value="/logining",method= RequestMethod.POST)
    public String Enter(Model model, @ModelAttribute HelloUser guest){
        if(guest.getId() != null &&  guest.getPassword()!= null){
            ///return "main";
            logger.info("login infor" + guest.getId() + guest.getPassword());
            if(userService.CheckByID(guest.getId(), guest.getPassword())) {
                model.addAttribute("allapps", aps.getAppsList());
                return "/main";
            }
            else
            {

                return "login";//弹窗
            }
        }
        else
            return "login";
    }*/
}
