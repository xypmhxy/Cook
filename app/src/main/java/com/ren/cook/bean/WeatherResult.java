package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/8/15
 */

public class WeatherResult {
    private String msg;

    private DataResult result;

    private String status;

    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setResult(DataResult result){
        this.result = result;
    }
    public DataResult getResult(){
        return this.result;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}
