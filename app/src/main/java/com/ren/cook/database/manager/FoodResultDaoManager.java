package com.ren.cook.database.manager;

import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.database.DBHelper;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22
 */

public class FoodResultDaoManager {

    public void insertToDB(List<FoodDataResult> result) {
        for (FoodDataResult foodDataResult : result) {
            DBHelper.getInstance().getDaoSession().getFoodDataResultDao().insert(foodDataResult);
        }
    }

    public List<FoodDataResult> queryAllFromDB() {
        return DBHelper.getInstance().getDaoSession().getFoodDataResultDao().queryBuilder().build().list();
    }
}
