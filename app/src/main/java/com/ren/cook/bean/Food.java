package com.ren.cook.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/08/21 0021
 */
@Entity
public class Food {

    @Id(autoincrement = false)
    private long classid;

    private String name;

    private String parentid;


    @Generated(hash = 1350262928)
    public Food(long classid, String name, String parentid) {
        this.classid = classid;
        this.name = name;
        this.parentid = parentid;
    }
    @Generated(hash = 866324199)
    public Food() {
    }


    public void setClassid(long classid){
        this.classid = classid;
    }
    public long getClassid(){
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

    @Override
    public String toString() {
        return "{" +
                ", classid='" + classid + '\'' +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                "}";
    }
}
