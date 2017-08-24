package com.ren.cook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.ren.cook.http.HttpApi;
import com.ren.cook.http.VolleyInterface;
import com.ren.cook.http.VolleyRequest;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by Administrator on 2017/8/23
 */

public class DetailActivity extends BaseActivity implements OnLoadmoreListener{
    @BindView(R.id.image_search)
    ImageView imageSearch;
    @BindView(R.id.listview_detail)
    ListView listView;
    @BindView(R.id.edit_search)
    EditText editSearch;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

    private int start =0;
    private  DetailListAdapter adapter;
    private List<DetailFood> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setTittle("菜单");
        showBack();
        refreshLayout.autoRefresh();
        requestDatas();
        refreshLayout.setOnLoadmoreListener(this);
    }

    private void requestDatas() {
        long id = getIntent().getLongExtra("id", -1);
        if (id == -1) {
            Toast.makeText(this, "网络异常，稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }
        final int num=10;
        Map<String, String> map = HttpApi.getdataMap();
        map.put("classid", id + "");
        map.put("start", start + "");
        map.put("num", num + "");
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

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        requestDatas();
    }

    @OnItemClick(R.id.listview_detail)
    public void OnItemClick(int postion){
        DetailFood detailFood=datas.get(postion);
        Intent intent=new Intent(this,PracticeActivity.class);
        intent.putExtra("data",detailFood);
        startActivity(intent);
    }
}
