package com.ren.cook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23
 */

public class DetailFood implements Serializable{
    private String classid;

    private List<Process> process ;

    private String preparetime;

    private List<Material> material ;

    private String name;

    private String id;

    private String pic;

    private String tag;

    private String peoplenum;

    private String content;

    private String cookingtime;

    public void setClassid(String classid){
        this.classid = classid;
    }
    public String getClassid(){
        return this.classid;
    }
    public void setProcess(List<Process> process){
        this.process = process;
    }
    public List<Process> getProcess(){
        return this.process;
    }
    public void setPreparetime(String preparetime){
        this.preparetime = preparetime;
    }
    public String getPreparetime(){
        return this.preparetime;
    }
    public void setMaterial(List<Material> material){
        this.material = material;
    }
    public List<Material> getMaterial(){
        return this.material;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return this.pic;
    }
    public void setTag(String tag){
        this.tag = tag;
    }
    public String getTag(){
        return this.tag;
    }
    public void setPeoplenum(String peoplenum){
        this.peoplenum = peoplenum;
    }
    public String getPeoplenum(){
        return this.peoplenum;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setCookingtime(String cookingtime){
        this.cookingtime = cookingtime;
    }
    public String getCookingtime(){
        return this.cookingtime;
    }
}
