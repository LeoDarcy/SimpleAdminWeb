package com.example.springweb.service;

import com.example.springweb.dao.AppStruct;
import com.example.springweb.mapper.AppMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AppService {
    @Resource
    private AppMapper appMapper;

    public List<AppStruct> getAppsList() {
        List<AppStruct> list = appMapper.findAll();
        return list;
    }

    /*public void InsertUser(HelloUser helloUser){
        helloMapper.insert(helloUser);
        System.out.println("Afterinsert:"+helloMapper.findAll());
    }*/
    public void InsertApp(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        AppStruct helloUser = objectMapper.convertValue(params, AppStruct.class);
        appMapper.insert(helloUser);
    }


    public AppStruct getOne(String id){
        //HelloUser result = new HelloUser();
        AppStruct result = appMapper.getOne(id);
        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=null;//索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
            return result;
        }
        System.out.println(result.toString());
        return result;
    }

    /*public void UpdateByID(HelloUser helloUser){
        helloMapper.updateByID(helloUser);
        System.out.println("AfterUpdate:"+ helloMapper.getOne(helloUser.getId()));
    }*/
    public void UpdateByID(Map<String, String> params){
        String id = params.get("id");
        //Long recordId = Long.parseLong(params.get("recordId"));
        //ObjectMapper objectMapper = new ObjectMapper();
        //HelloUser helloUser = objectMapper.convertValue(params, HelloUser.class);
        //helloMapper.updateByID(helloUser);
        AppStruct temp = appMapper.getOne(id);
        if(params.get("name")!=null)
            temp.setName(params.get("name"));
        if(params.get("company")!=null)
            temp.setCompany((params.get("company")));
        if(params.get("status")!=null)
            temp.setCompany((params.get("status")));
        appMapper.updateByID(temp);
    }


    public void DeleteByID(String id){
        appMapper.deleteByID(id);
        System.out.println("AfterDelete:"+appMapper.getOne(id));
    }

    public void UpdateStatusByID(String id, String status){
        appMapper.updateStatusByID(id, status);
        System.out.println("After Update:" + appMapper.getOne(id));
    }
    public void UpdateLevelByID(String id, String level){
        appMapper.updateLevelByID(id, level);
        System.out.println("After Update:" + appMapper.getOne(id));
    }
    public void UpdateCommentByID(String id, String comment){
        appMapper.updateCommentByID(id, comment);
        System.out.println("After Update:" + appMapper.getOne(id));
    }
    public void UpdateNamelegelByID(String id, String comment){
        appMapper.updateNamelegelByID(id, comment);
        System.out.println("After Update:" + appMapper.getOne(id));
    }
    public void UpdateKindCorrectByID(String id, String comment){
        appMapper.updateKindcorrectByID(id, comment);
        System.out.println("After Update:" + appMapper.getOne(id));
    }
    //返回一定范围内的列表
    public List<AppStruct> getAppsListByIndex(int begin, int end){
        List<AppStruct> all = getAppsList();
        if(begin < 0 || end >= all.size())
        {
            List<AppStruct> re = new ArrayList<AppStruct>();
            return re;
        }
        else
        {
            return all.subList(begin, end);
        }

    }
}
