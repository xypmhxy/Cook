package com.ren.cook.model;

import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;

/**
 * Created by Administrator on 2017/08/22 0022
 */

public class FoodTypeModelImp implements IFoodTypeModel {
    @Override
    public void requestFoodType(String url, VolleyInterface volleyInterface) {
        VolleyRequest.getInstance().RequestGet(url, null, volleyInterface);
    }
}
