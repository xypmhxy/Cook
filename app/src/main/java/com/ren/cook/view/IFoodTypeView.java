package com.ren.cook.view;

import com.android.volley.VolleyError;
import com.ren.cook.bean.FoodDataResult;

import java.util.List;

/**
 * Created by Administrator on 2017/08/22 0022
 */

public interface IFoodTypeView {
    void onRequestSuccess(List<FoodDataResult> result);
    void onRequestError(VolleyError error);
}
