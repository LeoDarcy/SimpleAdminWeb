package com.example.springweb.controller;

import com.example.springweb.dao.AppStruct;
import com.example.springweb.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class CheckApp {
    private int page = 0;
    private int showLines = 10;
    @Autowired
    AppService appsService;
    @RequestMapping(value = "/checkApp")
    public String CheckIn(@RequestParam(name="id", required=false, defaultValue="161220002") String id,
                          HttpSession session, Model model) {
        if(session.getAttribute("LoginUserId") == null)
            return "/login";
        System.out.println("check IN!!!");
        model.addAttribute("test", id);
        AppStruct app = appsService.getOne(id);
        if(app == null)
            return "redirect:/main";
        model.addAttribute("app", app);
        if(app.getStatus().equals("已审核"))
            return "app";
        else
            return "apptodo";
    }
    @RequestMapping("/assess")
    public String CheckIn(@RequestParam(name="namelegel")String namelegel,
                          @RequestParam(name = "kindcorrect")String kindcorrect,
                          @RequestParam(name="comment")String comment,@RequestParam(name="level")String level,
                          @RequestParam(name="id", required=false, defaultValue="161220002") String id,
                          HttpSession session, Model model){
        if(session.getAttribute("LoginUserId") == null)
            return "/login";
        System.out.println("assess:"+namelegel+kindcorrect+comment+level+id);
        AppStruct app = appsService.getOne(id);
        if(app == null)
            return "rediect:/main";
        if(!app.getStatus().equals("已审核"))
        {
            appsService.UpdateStatusByID(id, "已审核");
            appsService.UpdateLevelByID(id, level);
            appsService.UpdateCommentByID(id, comment);
            appsService.UpdateNamelegelByID(id, namelegel);
            appsService.UpdateKindCorrectByID(id, kindcorrect);
            app = appsService.getOne(id);
        }
        model.addAttribute("app", app);
        return "app";
    }

}
