package com.ren.cook.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15
 */

public class HttpApi {
    public static String FOOD_TYPE_URL = "https://way.jd.com/jisuapi/recipe_class?appkey=08ad4a362586453ce72438b77241ea44";
    public static String FOOD_URL = "https://way.jd.com/jisuapi/byclass";
    public static String SEARCH_URL = "https://way.jd.com/jisuapi/search";
    private static Map<String, String> dataMap;

    public static Map<String, String> getdataMap() {
        if (dataMap == null) {
            dataMap = new HashMap<>();
            dataMap.put("appkey", "08ad4a362586453ce72438b77241ea44");
        }else{
            dataMap.clear();
            dataMap.put("appkey", "08ad4a362586453ce72438b77241ea44");
        }
        return dataMap;
    }

    /**
     * 把map参数 拼接成 get请求的 url格式 ,最后和 传过来的url一起拼接
     */
    public static String paramsCastUrl(String url,Map<String, String> map) {
        if (map != null) {
            String params = "?";
            /** 遍历map，把 键值对应 */
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params += entry.getKey() + "=" + entry.getValue() + "&";
            }
            /** 把一个字符串 从 0 一直截取到 字符串减一个长度处 */
            params = params.substring(0, params.length() - 1);
            return url + params;
        }
        return url;
    }
}
