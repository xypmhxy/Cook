package com.ren.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.adapter.MainGridViewAdapter;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.database.manager.FoodResultDaoManager;
import com.ren.cook.http.HttpApi;
import com.ren.cook.presenter.FoodTypePresenter;
import com.ren.cook.presenter.SearchPresenter;
import com.ren.cook.view.IFoodTypeView;
import com.ren.cook.view.ISearchView;
import com.ren.cook.widget.PopUpWindow;

import java.util.List;

import butterknife.BindView;
import butterknife.OnEditorAction;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends BaseActivity implements IFoodTypeView,ISearchView {
    private static final String TAG = "MainActivity";
    @BindView(R.id.gridview_main)
    GridView gridView;
    @BindView(R.id.edit_search)
    EditText editSearch;

    private FoodResultDaoManager foodResultManager;
    private List<FoodDataResult> datas;
    private SearchPresenter searchPresenter;
    private PopUpWindow popUpWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        foodResultManager = new FoodResultDaoManager();
        datas = foodResultManager.queryAllFromDB();
        if (datas != null && !datas.isEmpty()) {
            updateGridView(datas);
        } else {
            FoodTypePresenter foodTypePresenter = new FoodTypePresenter(this);
            foodTypePresenter.requestFoodResult(HttpApi.FOOD_TYPE_URL);
        }
        searchPresenter=new SearchPresenter(this);
        popUpWindow=new PopUpWindow(this);
    }

    private void updateGridView(List<FoodDataResult> result) {
        datas = result;
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

    @OnEditorAction(R.id.edit_search)
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
        return false;
    }


    @OnItemClick(R.id.gridview_main)
    public void OnItemClick(int postion) {
        long id = datas.get(postion).getList().get(0).getClassid();
        Log.d(TAG, "id " + id);
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @OnTextChanged(R.id.edit_search)
    public void onTextChanged(CharSequence cs){
        searchPresenter.search(cs.toString());
    }

    @Override
    public void searchResult(List<DetailFood> list) {
        popUpWindow.setListDatas(list);
        popUpWindow.showAsDropDown(editSearch,0,30);
    }
}
