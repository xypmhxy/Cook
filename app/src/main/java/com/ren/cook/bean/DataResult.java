package com.ren.cook.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class DataResult {
    private String date;

    private String templow;

    private String temp;

    private String img;

    private String week;

    private String city;

    private String windpower;

    private List<Index> index ;

    private String cityid;

    private String pressure;

    private String temphigh;

    private String citycode;

    private String winddirect;

    private List<Daily> daily ;

    private String weather;


    private String humidity;

    private String windspeed;

    private List<Hourly> hourly ;

    private String updatetime;

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setTemplow(String templow){
        this.templow = templow;
    }
    public String getTemplow(){
        return this.templow;
    }
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
    public void setWeek(String week){
        this.week = week;
    }
    public String getWeek(){
        return this.week;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setWindpower(String windpower){
        this.windpower = windpower;
    }
    public String getWindpower(){
        return this.windpower;
    }
    public void setIndex(List<Index> index){
        this.index = index;
    }
    public List<Index> getIndex(){
        return this.index;
    }
    public void setCityid(String cityid){
        this.cityid = cityid;
    }
    public String getCityid(){
        return this.cityid;
    }
    public void setPressure(String pressure){
        this.pressure = pressure;
    }
    public String getPressure(){
        return this.pressure;
    }
    public void setTemphigh(String temphigh){
        this.temphigh = temphigh;
    }
    public String getTemphigh(){
        return this.temphigh;
    }
    public void setCitycode(String citycode){
        this.citycode = citycode;
    }
    public String getCitycode(){
        return this.citycode;
    }
    public void setWinddirect(String winddirect){
        this.winddirect = winddirect;
    }
    public String getWinddirect(){
        return this.winddirect;
    }
    public void setDaily(List<Daily> daily){
        this.daily = daily;
    }
    public List<Daily> getDaily(){
        return this.daily;
    }
    public void setWeather(String weather){
        this.weather = weather;
    }
    public String getWeather(){
        return this.weather;
    }
    public void setHumidity(String humidity){
        this.humidity = humidity;
    }
    public String getHumidity(){
        return this.humidity;
    }
    public void setWindspeed(String windspeed){
        this.windspeed = windspeed;
    }
    public String getWindspeed(){
        return this.windspeed;
    }
    public void setHourly(List<Hourly> hourly){
        this.hourly = hourly;
    }
    public List<Hourly> getHourly(){
        return this.hourly;
    }
    public void setUpdatetime(String updatetime){
        this.updatetime = updatetime;
    }
    public String getUpdatetime(){
        return this.updatetime;
    }
}
