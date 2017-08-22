package com.ren.cook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.adapter.MainGridViewAdapter;
import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.database.manager.FoodResultDaoManager;
import com.ren.cook.http.HttpApi;
import com.ren.cook.presenter.FoodTypePresenter;
import com.ren.cook.view.IFoodTypeView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends BaseActivity implements IFoodTypeView {
    @BindView(R.id.gridview_main)
    GridView gridView;

    FoodResultDaoManager foodResultManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodResultManager = new FoodResultDaoManager();
        List<FoodDataResult> datas = foodResultManager.queryAllFromDB();
        if (datas != null && !datas.isEmpty()) {
            updateGridView(datas);
        } else {
            FoodTypePresenter foodTypePresenter = new FoodTypePresenter(this);
            foodTypePresenter.requestFoodResult(HttpApi.FOOD_TYPE_URL);
        }

    }

    private void updateGridView(List<FoodDataResult> result) {
        MainGridViewAdapter adapter = new MainGridViewAdapter(result, MainActivity.this);
        gridView.setAdapter(adapter);
    }

    @Override
    public void onRequestSuccess(List<FoodDataResult> result) {
        updateGridView(result);
        foodResultManager.insertToDB(result);
    }

    @Override
    public void onRequestError(VolleyError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
