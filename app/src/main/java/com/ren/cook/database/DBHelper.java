package com.ren.cook.database;

import android.content.Context;

import com.ren.greendao.gen.DaoMaster;
import com.ren.greendao.gen.DaoSession;

/**
 * Created by Administrator on 2017/8/22
 */

public class DBHelper {

    private static DBHelper dbHelper;
    private DaoSession daoSession;

    private DBHelper(){}
    public static DBHelper getInstance(){
        if (dbHelper==null)
            dbHelper=new DBHelper();
        return dbHelper;
    }
    public void initDatabase(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "food_db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
