package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

public class Hourly {
    private String temp;

    private String img;

    private String weather;

    private String time;

    public void setTemp(String temp){
        this.temp = temp;
    }
    public String getTemp(){
        return this.temp;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getImg(){
        return this.img;
    }
    public void setWeather(String weather){
        this.weather = weather;
    }
    public String getWeather(){
        return this.weather;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
    }
}
