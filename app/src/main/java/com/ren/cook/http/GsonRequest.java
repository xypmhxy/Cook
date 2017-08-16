package com.ren.cook.http;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15
 */

public class GsonRequest extends StringRequest {

    private Map<String,String>map;

    public GsonRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public GsonRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    public GsonRequest(int method, String url, Map<String,String>map,Response.Listener<String> listener, Response.ErrorListener errorListener){
        this(method, url, listener, errorListener);
//        this.map=map;
    }
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Charset", "UTF-8");
        return headers;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return null;
    }
}
