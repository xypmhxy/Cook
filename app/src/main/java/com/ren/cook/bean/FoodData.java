package com.ren.cook.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/08/21 0021
 */

public class FoodData {
    private String msg;

    private List<FoodDataResult> result ;

    private String status;

    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setResult(List<FoodDataResult> result){
        this.result = result;
    }
    public List<FoodDataResult> getResult(){
        return this.result;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
}
