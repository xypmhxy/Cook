package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/08/21 0021
 */

public class FoodResult {
    private String code;

    private boolean charge;

    private String msg;

    private FoodData result;

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
    public void setResult(FoodData result){
        this.result = result;
    }
    public FoodData getResult(){
        return this.result;
    }
}
