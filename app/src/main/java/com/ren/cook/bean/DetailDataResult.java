package com.ren.cook.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */

public class DetailDataResult {
    private String num;

    private List<DetailFood> list ;

    public void setNum(String num){
        this.num = num;
    }
    public String getNum(){
        return this.num;
    }
    public void setList(List<DetailFood> list){
        this.list = list;
    }
    public List<DetailFood> getList(){
        return this.list;
    }
}
