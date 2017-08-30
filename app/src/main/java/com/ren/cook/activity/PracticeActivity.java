package com.ren.cook.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ren.cook.R;
import com.ren.cook.adapter.PracticeListAdapter;
import com.ren.cook.bean.DetailFood;
import com.ren.cook.widget.PullScaleListView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/8/24
 */

public class PracticeActivity extends BaseActivity {
    @BindView(R.id.rela_continar)
    RelativeLayout relativeLayout;
    @BindView(R.id.image_icon_practice)
    ImageView imageIconPractice;
    @BindView(R.id.text_name_practice)
    TextView textNamePractice;
    @BindView(R.id.text_person_num_practice)
    TextView textPersonNumPractice;
    @BindView(R.id.text_time_practice)
    TextView textTimePractice;
    @BindView(R.id.listview_practice)
    PullScaleListView listviewPractice;
    @BindView(R.id.btn_save_practice)
    Button btnSavePractice;

    private DetailFood detailFood;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        setTittle("菜单");
        showBack();
        detailFood = (DetailFood) getIntent().getSerializableExtra("data");
        if (detailFood == null) {
            Toast.makeText(this, "数据异常，请稍后再试", Toast.LENGTH_SHORT).show();
            return;
        }
        initData();
    }

    private void initData() {
        Picasso.with(this).load(detailFood.getPic()).into(imageIconPractice);
        textNamePractice.setText(detailFood.getName());
        textPersonNumPractice.setText(detailFood.getPeoplenum());
        textTimePractice.setText(detailFood.getCookingtime());
        listviewPractice.setHeaderContainer(relativeLayout, imageIconPractice);
        listviewPractice.setAdapter(new PracticeListAdapter(detailFood, this));
    }
}
