package com.ren.cook.http;

import com.android.volley.Response;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by Administrator on 2017/8/15
 */

public abstract class GsonResponse<T> implements Response.Listener<JSONObject> {
    private Class<T>cls;
    public GsonResponse(Class<T>cls){
        this.cls=cls;
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        if (jsonObject==null)
            return;
            Gson gson=new Gson();
       T t= gson.fromJson(jsonObject.toString(),cls);
        getResponse(t);
    }
    public abstract void getResponse(T t);
}
