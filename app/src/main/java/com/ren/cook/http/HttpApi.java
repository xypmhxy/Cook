package com.ren.cook.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15
 */

public class HttpApi {
    public static  String WHEATHER_URL_BEFORE="https://way.jd.com/jisuapi/weather?city=";
    public static  String WHEATHER_URL="https://way.jd.com/jisuapi/weather";
    public static  String WHEATHER_URL_AFTER="&appkey=08ad4a362586453ce72438b77241ea44";
    private static Map<String,String>weatherMap;

    public static Map<String,String>getWeatherMap(){
        if (weatherMap==null){
            weatherMap=new HashMap<>();
            weatherMap.put("appkey","08ad4a362586453ce72438b77241ea44");
        }
        return weatherMap;
    }
    /** 把map参数 拼接成 get请求的 url格式 ,最后和 传过来的url一起拼接 */
    public static String paramsCastUrl() {
        if (weatherMap != null) {
            String params = "?";
            /** 遍历map，把 键值对应 */
            for (Map.Entry<String, String> entry : weatherMap.entrySet()) {
                params += entry.getKey() + "=" + entry.getValue() + "&";
            }
            /** 把一个字符串 从 0 一直截取到 字符串减一个长度处 */
            params = params.substring(0, params.length() - 1);
            return WHEATHER_URL + params;
        }
        return WHEATHER_URL;
    }
}
