package com.ren.cook.model;

import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.DetailResult;
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;

import java.util.Map;

import static com.ren.cook.http.HttpApi.getdataMap;

/**
 * Created by Administrator on 2017/8/30
 */

public class SearchModelImp implements ISearchModel {
    @Override
    public void search(String text, VolleyInterface<DetailResult>volleyInterface) {
        Map<String,String>map=HttpApi.getdataMap();
        map.put("keyword",text);
        map.put("num",10+"");
        VolleyRequest.getInstance().RequestGet(HttpApi.SEARCH_URL,map,volleyInterface);
    }
}
