package com.example.springweb.controller;

import com.example.springweb.dao.AppStruct;
import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.AppService;
import com.example.springweb.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class AllAppController {
    private int page = 0;
    private int showLines = 10;
    @Autowired
    AppService appsService;
    @RequestMapping("/main")
    public String firstImpression(Model model) {

        List<AppStruct> apps = appsService.getAppsList();
        model.addAttribute("allapps", apps);
        return "main";
    }
    @RequestMapping("/main/nextPage")
    public String nextPage(Model model){
        List<AppStruct> apps = appsService.getAppsListByIndex(page*showLines, (page+1)*showLines);
        if(apps.size() > 0)
        {
            model.addAttribute("allapps", apps);
            page++;
        }
        return "main";
    }
    @RequestMapping("/main/lastPage")
    public String lastPage(Model model){
        if(page <= 0)
            return "main";
        List<AppStruct> apps = appsService.getAppsListByIndex((page-1)*showLines, page*showLines);
        model.addAttribute("allapps", apps);
        return "main";
    }
}
