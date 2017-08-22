package com.ren.cook.model;

import com.ren.cook.http.VolleyInterface;

/**
 * Created by Administrator on 2017/08/22 0022
 */

public interface IFoodTypeModel {
    void requestFoodType(String url,VolleyInterface volleyInterface);
}
