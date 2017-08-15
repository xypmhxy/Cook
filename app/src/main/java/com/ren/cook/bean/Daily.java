package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

public class Daily {
    private String date;

    private String sunrise;

    private String week;

    private String sunset;

    private Night night;

    private Day day;

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setSunrise(String sunrise){
        this.sunrise = sunrise;
    }
    public String getSunrise(){
        return this.sunrise;
    }
    public void setWeek(String week){
        this.week = week;
    }
    public String getWeek(){
        return this.week;
    }
    public void setSunset(String sunset){
        this.sunset = sunset;
    }
    public String getSunset(){
        return this.sunset;
    }
    public void setNight(Night night){
        this.night = night;
    }
    public Night getNight(){
        return this.night;
    }
    public void setDay(Day day){
        this.day = day;
    }
    public Day getDay(){
        return this.day;
    }
}
