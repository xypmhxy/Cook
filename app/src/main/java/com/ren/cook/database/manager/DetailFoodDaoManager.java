package com.ren.cook.database.manager;

import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.database.DBHelper;
import com.ren.greendao.gen.DetailFoodDao;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31
 */

public class DetailFoodDaoManager {

    public void insertToDB(DetailFood detailFood) {
            DBHelper.getInstance().getDaoSession().getDetailFoodDao().insertOrReplace(detailFood);
    }

    public List<DetailFood> queryById(long classid) {
        return  DBHelper.getInstance().getDaoSession().getDetailFoodDao().queryBuilder()
                .where(DetailFoodDao.Properties.Id.eq(classid))
                .limit(1)
                .build()
                .list();
    }

    public List<DetailFood> queryAll() {
        return  DBHelper.getInstance().getDaoSession().getDetailFoodDao().queryBuilder()
                .build()
                .list();
    }
}
