package com.ren.cook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.ren.cook.R;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.Material;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/23
 */

public class PracticeListAdapter extends BaseAdapter {

    private DetailFood data;
    private LayoutInflater inflater;

    public PracticeListAdapter(DetailFood data, Context context) {
        this.data = data;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.getMaterial().size();
    }

    @Override
    public Material getItem(int position) {
        return data.getMaterial().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Material data=getItem(position);
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_practice_list ,null );
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.material.setText("  "+data.getMname()+" "+data.getAmount());
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.text_material_item_practice)
        CheckBox material ;
        public ViewHolder(View convertView){
            ButterKnife.bind(this,convertView);
        }
    }
}
