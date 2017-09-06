package com.ren.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.ren.cook.R;
import com.ren.cook.adapter.DetailListAdapter;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.DetailResult;
import com.ren.cook.database.manager.DetailFoodDaoManager;
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;
import com.ren.cook.presenter.SearchPresenter;
import com.ren.cook.view.ISearchView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;

/**
 * Created by Administrator on 2017/8/23
 */

public class DetailActivity extends BaseActivity implements OnLoadmoreListener,ISearchView{

    private static final int SEARCH_BY_ID=0;
    private static final int SEARCH_BY_NAME=1;

    @BindView(R.id.image_search)
    ImageView imageSearch;
    @BindView(R.id.listview_detail)
    ListView listView;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

    private int start =0;
    private int whichSearch=SEARCH_BY_ID;
    private SearchPresenter searchPresenter;
    private  DetailListAdapter adapter;
    private DetailFoodDaoManager daoManager;
    private List<DetailFood> datas;
    private int  num=10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setTittle("菜单");
        showBack();
        refreshLayout.autoRefresh();
        searchPresenter=new SearchPresenter(this);
        daoManager=new DetailFoodDaoManager();
        requestDatasById();
        refreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return getIntent().getBooleanExtra("isCollection",false) || super.onCreateOptionsMenu(menu);
    }

    private void requestDatasById() {
        long id = getIntent().getLongExtra("id", -1);
        if (id == -1) {
            requestDatasByName();
            return;
        }
        Map<String, String> map = HttpApi.getdataMap();
        map.put("classid", id + "");
        map.put("start", start + "");
        map.put("num", num + "");
        startRequest(map);
    }

    private void startRequest(Map<String, String> map){
        VolleyRequest.getInstance().RequestGet(HttpApi.FOOD_URL, map, new VolleyInterface<DetailResult>(DetailResult.class) {
            @Override
            public void onMySuccess(DetailResult result) {
                if (adapter==null){
                    datas=result.getResult().getResult().getList();
                    adapter = new DetailListAdapter(datas, DetailActivity.this);
                    listView.setAdapter(adapter);
                    refreshLayout.finishRefresh();
                    refreshLayout.setEnableRefresh(false);
                    refreshLayout.setEnableLoadmore(true);
                }else{
                    datas.addAll(result.getResult().getResult().getList());
                    adapter.notifyDataSetChanged();
                }
                refreshLayout.finishLoadmore();
                start+=num;
            }

            @Override
            public void onMyError(VolleyError error) {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadmore();
                refreshLayout.setEnableRefresh(false);
                refreshLayout.setEnableLoadmore(true);
                Toast.makeText(DetailActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void requestDatasByName(){
        whichSearch=SEARCH_BY_NAME;
        String name=getIntent().getStringExtra("name");
        if (name == null) {
            loadDatasFromDB();
            return;
        }
        searchPresenter.search(20,null,name);
    }

    private void loadDatasFromDB(){
        boolean isCollection=getIntent().getBooleanExtra("isCollection",false);
        if (isCollection){
            setTittle("我的收藏");
            datas=daoManager.queryAll();
            adapter = new DetailListAdapter(datas, DetailActivity.this);
            adapter.hideColletionButton();
            listView.setAdapter(adapter);
            return ;
            }
        Toast.makeText(this, "网络异常，稍后再试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        if (whichSearch==SEARCH_BY_ID)
            requestDatasById();
        else{
            Toast.makeText(this, "没有更多了 (⊙﹏⊙)", Toast.LENGTH_SHORT).show();
            refreshLayout.finishLoadmore();
        }
    }

    @OnTextChanged(R.id.edit_search)
    public void onTextChanged(CharSequence cs){
        refreshLayout.setEnableRefresh(true);
        refreshLayout.autoRefresh();
        searchPresenter.search(20,null,cs.toString());
    }

    @OnItemClick(R.id.listview_detail)
    public void OnItemClick(int postion){
        DetailFood detailFood=datas.get(postion);
        Intent intent=new Intent(this,PracticeActivity.class);
        intent.putExtra("data",detailFood);
        startActivity(intent);
    }

    @Override
    public void searchResult(List<DetailFood> list) {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadmore();
        refreshLayout.setEnableRefresh(false);
        refreshLayout.setEnableLoadmore(true);
        if (adapter==null){
            datas=list;
            adapter = new DetailListAdapter(datas, DetailActivity.this);
            listView.setAdapter(adapter);
        }else{
            datas.clear();
            datas.addAll(list);
            adapter.notifyDataSetChanged();
        }
        refreshLayout.finishLoadmore();
    }
}
