package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/08/21 0021
 */

public class Food {
    private String classid;

    private String name;

    private String parentid;

    public void setClassid(String classid){
        this.classid = classid;
    }
    public String getClassid(){
        return this.classid;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setParentid(String parentid){
        this.parentid = parentid;
    }
    public String getParentid(){
        return this.parentid;
    }

}
