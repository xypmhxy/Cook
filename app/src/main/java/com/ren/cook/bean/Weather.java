package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/8/15
 */

public class Weather {
    private String code;

    private boolean charge;

    private String msg;

    private WeatherResult result;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setCharge(boolean charge){
        this.charge = charge;
    }
    public boolean getCharge(){
        return this.charge;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setResult(WeatherResult result){
        this.result = result;
    }
    public WeatherResult getResult(){
        return this.result;
    }
}
