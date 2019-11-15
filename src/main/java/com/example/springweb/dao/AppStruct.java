package com.example.springweb.dao;

import java.io.Serializable;

public class AppStruct implements Serializable {
    private String id;
    private String name;
    private String company;
    private int status;//，负数表示不存在，0表示未审核，1表示审核通过，2表示审核未通过
    public AppStruct(){
        id = null;
        name = null;
        company = null;
        status = -1;
    }
    public AppStruct(String id,String name,String company, int sta){
        this.id = id;
        this.name = name;
        this.company = company;
        this.status = sta;
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

    @Override
    public String toString() {
        return id + "," + name + "," + company + ", now status is " + status;
    }
}
