package com.ren.cook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.adapter.MainGridViewAdapter;
import com.ren.cook.bean.FoodResult;
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;
import com.ren.cook.utils.StatusBarUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.gridview_main)
    GridView gridView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.statusBarColor));
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
        VolleyRequest.getInstance(this).RequestGet(HttpApi.FOOD_TYPE_URL, map,new VolleyInterface<FoodResult>(FoodResult.class) {
            @Override
            public void onMySuccess(FoodResult   result) {
                MainGridViewAdapter adapter=new MainGridViewAdapter(result.getResult().getResult(),MainActivity.this);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onMyError(VolleyError error) {
            }
        });

    }
}
