package com.ren.cook.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ren.cook.R;
import com.ren.cook.bean.Weather;
import com.ren.cook.bean.WeatherResult;
import com.ren.cook.http.GsonRequest;
import com.ren.cook.http.GsonResponse;
import com.ren.cook.http.HttpApi;
import com.ren.cook.utils.StatusBarUtil;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        StatusBarUtil.setColor(this, Color.WHITE);
        setContentView(R.layout.activity_main);
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        String city= null;
        try {
             city=URLEncoder.encode("北京","UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        GsonRequest jsonObjectRequest = new GsonRequest(Request.Method.GET,"https://way.jd.com/jisuapi/weather?city="+city+"&appkey=08ad4a362586453ce72438b77241ea44", null,
                new GsonResponse<Weather>(Weather.class) {
                    @Override
                    public void getResponse(Weather weather) {
                        Log.d("rq","");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        mQueue.add(jsonObjectRequest);
        super.onCreate(savedInstanceState);
    }
}
