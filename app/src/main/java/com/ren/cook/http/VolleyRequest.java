package com.ren.cook.http;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by Administrator on 2017/08/15 0015
 */

public class VolleyRequest {
    private static StringRequest stringRequest;
    private static RequestQueue mQueue;
    private static VolleyRequest volleyRequest;

    private VolleyRequest() {
    }

    public static VolleyRequest getInstance(Context mContext) {
        if (volleyRequest == null) {
            volleyRequest = new VolleyRequest();
            mQueue = Volley.newRequestQueue(mContext);
        }
        return volleyRequest;
    }

    public static VolleyRequest getInstance() {
        return volleyRequest;
    }

    public void RequestGet(String url,  Map<String, String> map, VolleyInterface vif) {
        url=HttpApi.paramsCastUrl(url,map);
        stringRequest = new StringRequest(Request.Method.GET, url,
                vif.loadingListener(),
                vif.errorListener()
        );
        mQueue.add(stringRequest);

        //注意千万不要调用start来开启。这样写是不对的。
        //因为在源码里，当我们调用Volley.newRequestQueue()来实例化一个请求队列的时候
        //就已经使用queue.start(); 方法来开启了一个工作线程，所以我们如果多次调用
        //newRequestQueue来实例化请求队列就会多次调用start方法，这样做势必增加性能的消耗
        //所以我们一定要把volley的请求队列全局化（可以使用单例模式或在application初始化）。
        //并且我们不应当手动调用start。
//      MyApplication.getHttpQueues().start();
    }

    public void RequestPost(String url, final Map<String, String> params, VolleyInterface vif) {
//        stringRequest = new StringRequest(url, vif.loadingListener(), vif.errorListener()){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                return params;
//            }
//        };
//        mQueue.add(stringRequest);
    }
}
