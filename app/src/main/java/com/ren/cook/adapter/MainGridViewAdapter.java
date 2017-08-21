package com.ren.cook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ren.cook.R;
import com.ren.cook.bean.FoodDataResult;
import com.ren.cook.widget.EaseImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/08/21 0021
 */

public class MainGridViewAdapter extends BaseAdapter {

    private List<FoodDataResult>datas;
    private LayoutInflater inflater;
    private int images[]={R.drawable.type1 , R.drawable.type2 , R.drawable.type3, R.drawable.type4 , R.drawable.type5 , R.drawable.type6  };

    public MainGridViewAdapter(List<FoodDataResult> datas, Context context) {
        this.datas = datas;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public FoodDataResult getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        FoodDataResult data=getItem(position);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_main_grid,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) convertView.getTag();
            viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textView.setText(data.getName());
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.image_icon_main_grid_item)
        EaseImageView imageView;
        @BindView(R.id.text_tittle_main_grid_item)
        TextView textView;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
