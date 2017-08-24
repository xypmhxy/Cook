package com.ren.cook.http;

import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/08/15 0015
 */

public abstract class VolleyInterface<T>  {
    private  Response.Listener<String> mListener;
    private  Response.ErrorListener mErrorListener;
    private Gson gson;
    private Class<T>cls;

    protected VolleyInterface(Class<T>cls) {
        gson=new Gson();
        this.cls=cls;
    }

    public abstract void onMySuccess(T result);
    public abstract void onMyError(VolleyError error);

    public Listener<String> loadingListener() {
        mListener = new Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    onMySuccess(gson.fromJson(response,cls));
                }catch (Exception e){
                    e.printStackTrace();
                    onMyError(new VolleyError(e.getMessage()));
                }

            }
        };
        return mListener;
    }

    public ErrorListener errorListener() {
         mErrorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
            }
        };
        return mErrorListener;

    }

}
