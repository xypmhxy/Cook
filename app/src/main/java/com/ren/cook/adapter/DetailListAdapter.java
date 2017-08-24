package com.ren.cook.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ren.cook.R;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.Food;
import com.ren.cook.bean.FoodDataResult;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/23
 */

public class DetailListAdapter extends BaseAdapter {

    private List<DetailFood> datas;
    private LayoutInflater inflater;

    public DetailListAdapter(List<DetailFood>datas, Context context) {
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
            convertView=inflater.inflate(R.layout.item_detail_listview ,null );
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        Picasso.with(convertView.getContext()).load(data.getPic())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(viewHolder.icon);
        viewHolder.name.setText(data.getName());
        viewHolder.detail.setText(data.getContent());
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.image_icon_item_detail)
        ImageView icon ;
        @BindView(R.id.text_name_item_detail)
        TextView name ;
        @BindView(R.id.text_detail_item_detail)
        TextView detail;
        public ViewHolder(View convertView){
            ButterKnife.bind(this,convertView);
        }
    }
}
