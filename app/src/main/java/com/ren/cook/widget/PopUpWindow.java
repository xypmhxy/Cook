package com.ren.cook.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.ren.cook.R;
import com.ren.cook.adapter.SearchListAdapter;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.DetailResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.width;
import static android.icu.text.RelativeDateTimeFormatter.Direction.THIS;
import static com.ren.cook.R.id.rootView;

/**
 * Created by Administrator on 2017/8/30
 */

public class PopUpWindow extends PopupWindow {

    private Context context;
    @BindView(R.id.listview)
    public ListView listView;
    private List<DetailFood> list;
    private SearchListAdapter adapter;

    public PopUpWindow(Context context){
        this.context=context;
        View rootView= LayoutInflater.from(context).inflate(R.layout.layout_popupwindow,null);
        ButterKnife.bind(this,rootView);
        setContentView(rootView);
        list=new ArrayList<>();
        adapter=new SearchListAdapter(list,context);
        listView.setAdapter(adapter);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
    }


    public void setListDatas(List<DetailFood> list){
        this.list.clear();
        this.list.addAll(list);
        adapter.notifyDataSetInvalidated();
    }
    @Override
    public void setContentView(View contentView) {
        super.setContentView(contentView);
    }
}
