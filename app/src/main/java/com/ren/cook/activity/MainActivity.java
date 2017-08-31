package com.ren.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.adapter.MainGridViewAdapter;
import com.ren.cook.adapter.SearchListAdapter;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.database.manager.FoodResultDaoManager;
import com.ren.cook.http.HttpApi;
import com.ren.cook.presenter.FoodTypePresenter;
import com.ren.cook.presenter.SearchPresenter;
import com.ren.cook.view.IFoodTypeView;
import com.ren.cook.view.ISearchView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;

/**
 * Created by Administrator on 2017/8/15
 */

public class MainActivity extends BaseActivity implements IFoodTypeView, ISearchView {
    private static final String TAG = "MainActivity";
    @BindView(R.id.gridview_main)
    GridView gridView;
    @BindView(R.id.listview_main)
    ListView listView;
    @BindView(R.id.progressbar)
    ContentLoadingProgressBar progressbar;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.image_search)
    ImageView imageSearch;

    private FoodResultDaoManager foodResultManager;
    private List<FoodDataResult> datas;
    private List<DetailFood> searchDatas;
    private SearchPresenter searchPresenter;
    private SearchListAdapter searchAdapter;
    private String text="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        foodResultManager = new FoodResultDaoManager();
        datas = foodResultManager.queryAllFromDB();
        if (datas != null && !datas.isEmpty()) {
            updateGridView(datas);
        } else {
            FoodTypePresenter foodTypePresenter = new FoodTypePresenter(this);
            foodTypePresenter.requestFoodResult(progressbar, HttpApi.FOOD_TYPE_URL);
        }
        searchPresenter = new SearchPresenter(this);
    }

    private void updateGridView(List<FoodDataResult> result) {
        datas = result;
        MainGridViewAdapter adapter = new MainGridViewAdapter(result, MainActivity.this);
        gridView.setAdapter(adapter);
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void onRequestSuccess(List<FoodDataResult> result) {
        updateGridView(result);
        foodResultManager.insertToDB(result);
    }

    @Override
    public void onRequestError(VolleyError error) {
        progressbar.setVisibility(View.GONE);
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @OnEditorAction(R.id.edit_search)
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name", v.getText().toString());
        startActivity(intent);
        return false;
    }

    @OnClick(R.id.image_search)
    public void onClick(){
        if (text.length()>0){
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("name", text);
            startActivity(intent);
        }
    }

    @OnItemClick({R.id.gridview_main, R.id.listview_main})
    public void OnItemClick(AdapterView<?> parent, int postion) {
        if (parent == gridView) {
            long id = datas.get(postion).getList().get(0).getClassid();
            Log.d(TAG, "id " + id);
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, PracticeActivity.class);
            intent.putExtra("data", searchDatas.get(postion));
            startActivity(intent);
        }
    }

    @OnTextChanged(R.id.edit_search)
    public void onTextChanged(CharSequence cs) {
        text = cs.toString().trim();
        if (text.length() == 0) {
            listView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
            progressbar.setVisibility(View.GONE);
        } else {
            searchPresenter.search(10, progressbar, cs.toString());
        }
    }

    @Override
    public void searchResult(List<DetailFood> list) {
        progressbar.setVisibility(View.GONE);
        if (text.length() == 0)
            return;
        if (list.isEmpty()) {
            listView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
            return;
        } else {
            listView.setVisibility(View.VISIBLE);
            gridView.setVisibility(View.GONE);
        }
        if (searchAdapter == null) {
            searchDatas = list;
            searchAdapter = new SearchListAdapter(searchDatas, this);
            listView.setAdapter(searchAdapter);
        } else {
            searchDatas.clear();
            searchDatas.addAll(list);
            searchAdapter.notifyDataSetChanged();
        }
    }
}
