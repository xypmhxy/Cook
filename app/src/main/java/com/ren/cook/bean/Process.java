package com.ren.cook.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/23.
 */

public class Process implements Serializable {
    private String pcontent;

    private String pic;

    public void setPcontent(String pcontent){
        this.pcontent = pcontent;
    }
    public String getPcontent(){
        return this.pcontent;
    }
    public void setPic(String pic){
        this.pic = pic;
    }
    public String getPic(){
        return this.pic;
    }
}
