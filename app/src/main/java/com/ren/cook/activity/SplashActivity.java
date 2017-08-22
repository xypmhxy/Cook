package com.ren.cook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ren.cook.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/08/15 0015
 */

public class SplashActivity extends Activity  {
    int bgImages[]={R.drawable.bg_1,R.drawable.bg_2,R.drawable.bg_3};
    @BindView(R.id.rootView)
    LinearLayout bgLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        Random random=new Random();
        int index=random.nextInt(3);
        bgLayout.setBackgroundResource(bgImages[index]);
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task,1500);
    }

}
