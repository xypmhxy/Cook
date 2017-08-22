package com.ren.cook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.adapter.MainGridViewAdapter;
import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.bean.FoodResult;
import com.ren.cook.database.DBHelper;
import com.ren.cook.database.manager.FoodResultDaoManager;
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;
import com.ren.cook.utils.StatusBarUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends BaseActivity {
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
            MainGridViewAdapter adapter = new MainGridViewAdapter(datas, MainActivity.this);
            gridView.setAdapter(adapter);
        } else {
            VolleyRequest.getInstance(this).RequestGet(HttpApi.FOOD_TYPE_URL, null, new VolleyInterface<FoodResult>(FoodResult.class) {
                @Override
                public void onMySuccess(FoodResult result) {
                    MainGridViewAdapter adapter = new MainGridViewAdapter(result.getResult().getResult(), MainActivity.this);
                    gridView.setAdapter(adapter);
                    foodResultManager.insertToDB(result);
                    List<FoodDataResult> datas = foodResultManager.queryAllFromDB();
                }

                @Override
                public void onMyError(VolleyError error) {
                }
            });
        }

    }


}
