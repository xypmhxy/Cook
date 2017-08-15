package com.ren.cook.bean;

/**
 * Created by Administrator on 2017/8/15.
 */

public class Night {
    private String templow;

    private String img;

    private String winddirect;

    private String windpower;

    private String weather;

    public void setTemplow(String templow){
        this.templow = templow;
    }
    public String getTemplow(){
        return this.templow;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getImg(){
        return this.img;
    }
    public void setWinddirect(String winddirect){
        this.winddirect = winddirect;
    }
    public String getWinddirect(){
        return this.winddirect;
    }
    public void setWindpower(String windpower){
        this.windpower = windpower;
    }
    public String getWindpower(){
        return this.windpower;
    }
    public void setWeather(String weather){
        this.weather = weather;
    }
    public String getWeather(){
        return this.weather;
    }

}
