package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/8/23
 */

public class DetailData {
    private String msg;

    private DetailDataResult result;

    private String status;

    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setResult(DetailDataResult result){
        this.result = result;
    }
    public DetailDataResult getResult(){
        return this.result;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}
