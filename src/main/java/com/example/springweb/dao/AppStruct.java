package com.example.springweb.dao;

import java.io.Serializable;
import java.util.Map;

public class AppStruct implements Serializable {
    private String id;
    private String name;
    private String company;
    private String status;//，负数表示不存在，0表示未审核，1表示审核通过，2表示审核未通过
    private String kinds;//分类条目
    private String level;//类别
    private String items;//测评方向
    private String comment;//评论
    public AppStruct(){
        id = null;name = null;company = null;
        status = null;kinds=null;level=null;
        items=null;comment=null;
    }
    public AppStruct(Map<String, String> mp){
        if(mp.containsKey("id"))
            this.id = mp.get("id");
        if(mp.containsKey("name"))
            this.name = mp.get("name");
        if(mp.containsKey("company"))
            this.company = mp.get("company");
        if(mp.containsKey("status"))
            this.status = mp.get("status");
        if(mp.containsKey("kinds"))
            this.status = mp.get("kinds");
        if(mp.containsKey("level"))
            this.status = mp.get("level");
        if(mp.containsKey("items"))
            this.status = mp.get("items");
        if(mp.containsKey("comments"))
            this.status = mp.get("comments");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String com) {
        this.company = com;
    }

    public String  getStatus(){return this.status;}
    public void setStatus(String sta){this.status=sta;}

    public String getKinds(){return kinds;}
    public void setKinds(String k){kinds=k;}

    public String getLevel(){return level;}
    public void setLevel(String le){level=le;}
    public String getItems(){return items;}
    public void setItems(String it){items=it;}
    public String getComment(){return comment;}
    public void setComment(String co){comment=co;}
    @Override
    public String toString() {
        return id + "," + name + "," + company + ", now status is " + status;
    }
}
