package com.ren.cook.application;

import android.app.Application;

import com.ren.cook.database.DBHelper;
import com.ren.cook.http.VolleyRequest;

/**
 * Created by Administrator on 2017/8/16
 */


public class CookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyRequest.getInstance(this);
        DBHelper.getInstance().initDatabase(this);
    }
}
