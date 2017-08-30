package com.ren.cook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ren.cook.R;
import com.ren.cook.bean.DetailFood;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/23
 */

public class SearchListAdapter extends BaseAdapter {

    private List<DetailFood> datas;
    private LayoutInflater inflater;

    public SearchListAdapter(List<DetailFood>datas, Context context) {
        this.datas = datas;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public DetailFood getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DetailFood data=getItem(position);
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_search_list ,null );
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.name.setText(data.getName());
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.text)
        TextView name ;
        public ViewHolder(View convertView){
            ButterKnife.bind(this,convertView);
        }
    }
}
