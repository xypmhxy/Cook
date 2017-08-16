package com.ren.cook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.bean.Weather;
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.mainColor));
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        String city= getIntent().getStringExtra("city");
        try {
             city=URLEncoder.encode(city,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,String> map=HttpApi.getWeatherMap();
        map.put("city",city);
        String Url=HttpApi.paramsCastUrl();
        VolleyRequest.getInstance(this).RequestGet(Url, map,new VolleyInterface<Weather>(Weather.class) {
            @Override
            public void onMySuccess(Weather result) {
                Log.d("rq","");
            }

            @Override
            public void onMyError(VolleyError error) {
                Log.d("rq","");
            }
        });
//        GsonRequest jsonObjectRequest = new GsonRequest(Request.Method.GET,"https://way.jd.com/jisuapi/weather?city="+city+"&appkey=08ad4a362586453ce72438b77241ea44", null,
//                new GsonResponse<Weather>(Weather.class) {
//                    @Override
//                    public void getResponse(Weather weather) {
//                        Log.d("rq","");
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//        mQueue.add(jsonObjectRequest);
        super.onCreate(savedInstanceState);
    }
}
