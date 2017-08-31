package com.ren.cook.model;

import com.ren.cook.bean.DetailResult;
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/30
 */

public class SearchModelImp implements ISearchModel {
    @Override
    public void search(int num,String text, VolleyInterface<DetailResult>volleyInterface) {
        Map<String,String>map=HttpApi.getdataMap();
        try {
            map.put("keyword", URLEncoder.encode(text,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map.put("num",num+"");
        VolleyRequest.getInstance().RequestGet(HttpApi.SEARCH_URL,map,volleyInterface);
    }
}
