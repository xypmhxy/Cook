package com.ren.cook.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.ren.cook.R;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.bean.Material;
import com.ren.cook.bean.Process;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

import static android.R.attr.process;

/**
 * Created by Administrator on 2017/8/23
 */

public class PracticeListAdapter extends BaseAdapter {

    private DetailFood data;
    private LayoutInflater inflater;
    private  Material material=null;

    public PracticeListAdapter(DetailFood data, Context context) {
        this.data = data;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.getMaterial().size()+data.getProcess().size();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position>=data.getMaterial().size())
            return 1;
        else return 0;
    }

    @Override
    public Object getItem(int position) {
        if (getItemViewType(position)==0)
            return data.getMaterial().get(position);
        else
            return data.getProcess().get(position-data.getMaterial().size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Process process=null;
        if (getItemViewType(position)==0)
            material= (Material) getItem(position);
        else
             process= (Process) getItem(position);
        ViewHolder viewHolder=null;
        ViewHolderProcess viewHolderProcess=null;
        if (convertView==null){
            if (getItemViewType(position)==0){
                convertView=inflater.inflate(R.layout.item_practice_list ,null );
                viewHolder=new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }else{
                convertView=inflater.inflate(R.layout.item_practice_process ,null );
                viewHolderProcess=new ViewHolderProcess(convertView);
                convertView.setTag(viewHolderProcess);
            }
        }else{
            if (getItemViewType(position)==0)
                viewHolder= (ViewHolder) convertView.getTag();
            else
                viewHolderProcess= (ViewHolderProcess) convertView.getTag();
        }
        if (getItemViewType(position)==0){
            viewHolder.material.setChecked(material.isAlready());
            viewHolder.material.setText("  "+material.getMname()+" - - - "+material.getAmount());
            viewHolder.material.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Material material= (Material) getItem(position);
                    material.setAlready(isChecked);
                }
            });
        }else{
            viewHolderProcess.process.setText(process.getPcontent());
        }
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.text_material_item_practice)
        CheckBox material ;

        public ViewHolder(View convertView){
            ButterKnife.bind(this,convertView);
        }
    }

    class ViewHolderProcess{
        @BindView(R.id.text_process_item_practice)
        TextView process ;
        public ViewHolderProcess(View convertView){
            ButterKnife.bind(this,convertView);
        }
    }
}
