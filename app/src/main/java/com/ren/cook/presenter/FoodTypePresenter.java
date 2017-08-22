package com.ren.cook.presenter;

import com.android.volley.VolleyError;
import com.ren.cook.bean.FoodResult;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.model.FoodTypeModelImp;
import com.ren.cook.view.IFoodTypeView;

/**
 * Created by Administrator on 2017/08/22 0022
 */

public class FoodTypePresenter {
    private IFoodTypeView view;
    private FoodTypeModelImp foodTypeImp;


    public FoodTypePresenter(IFoodTypeView view) {
        this.view = view;
        foodTypeImp = new FoodTypeModelImp();
    }

    public void requestFoodResult(String url) {
        foodTypeImp.requestFoodType(url, new VolleyInterface<FoodResult>(FoodResult.class) {
            @Override
            public void onMySuccess(FoodResult result) {
                view.onRequestSuccess(result.getResult().getResult());
            }

            @Override
            public void onMyError(VolleyError error) {
                view.onRequestError(error);
            }
        });
    }
}
