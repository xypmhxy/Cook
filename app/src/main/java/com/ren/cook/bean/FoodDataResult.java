package com.ren.cook.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/08/21 0021
 */

public class FoodDataResult {
    private String classid;

    private String name;

    private List<Food> list ;

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
    public void setList(List<Food> list){
        this.list = list;
    }
    public List<Food> getList(){
        return this.list;
    }
    public void setParentid(String parentid){
        this.parentid = parentid;
    }
    public String getParentid(){
        return this.parentid;
    }
}
