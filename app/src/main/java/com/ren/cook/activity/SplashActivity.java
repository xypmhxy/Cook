package com.ren.cook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.ren.cook.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/08/15 0015
 */

public class SplashActivity extends Activity implements AMapLocationListener {
    int bgImages[]={R.drawable.bg_1,R.drawable.bg_2,R.drawable.bg_3};
    @BindView(R.id.rootView)
    LinearLayout bgLayout;

    private AMapLocationClient mLocationClient ;
    private  long currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        Random random=new Random();
        int index=random.nextInt(3);
        bgLayout.setBackgroundResource(bgImages[index]);
        startLocation();
        currentTime=System.currentTimeMillis();
    }
    private void startLocation(){
        //初始化AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        mLocationOption.setOnceLocation(true);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(true);
        //给定位客户端对象设置定位参数
        mLocationClient=new AMapLocationClient(this);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.setLocationListener(this);
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void onLocationChanged(final AMapLocation aMapLocation) {
        long time=System.currentTimeMillis();
        if (time-currentTime<1000){
            final Timer timer=new Timer();
            TimerTask timerTask=new TimerTask() {
                @Override
                public void run() {
                    Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                    intent.putExtra("city","成都");
                    if (aMapLocation.getErrorCode()==0)
                        intent.putExtra("city",aMapLocation.getCity());
                    startActivity(intent);
                    timer.cancel();
                    finish();
                }
            };
            timer.schedule(timerTask,1500);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stopLocation();
        mLocationClient.onDestroy();
    }
}
