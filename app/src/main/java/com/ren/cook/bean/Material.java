package com.ren.cook.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/23.
 */

public class Material implements Serializable {
    private String amount;

    private String mname;

    private String type;

    public void setAmount(String amount){
        this.amount = amount;
    }
    public String getAmount(){
        return this.amount;
    }
    public void setMname(String mname){
        this.mname = mname;
    }
    public String getMname(){
        return this.mname;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
