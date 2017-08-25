package com.ren.cook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/8/25
 */

public class PullScaleListView extends ListView implements AbsListView.OnScrollListener{

    private boolean isOnTop=false;
    private boolean scaleing=false;
    private float pressY;
    /*头部View 的容器*/
    private RelativeLayout mHeaderContainer;
    /*头部View 的图片*/
    private ImageView mHeaderImg;

    private int mHeaderHeight;

    public PullScaleListView(Context context) {
        super(context);
        init();
    }

    public PullScaleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PullScaleListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        setOnScrollListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN :
                pressY=ev.getY();
                break;
            case MotionEvent.ACTION_MOVE :
                float moveY=ev.getY();
                float offY=moveY-pressY;
                if (scaleing){
                    if (offY>0)
                        scaleImage(offY);
                    return true;
                }
                if (isOnTop&&!scaleing){
                    if (offY>0)
                        scaleing=true ;
                }
                break;

        }
        return super.onTouchEvent(ev);
    }

    private void scaleImage(float offY){
        float scale=offY/1000/2+1.0f;
        int height= (int) (mHeaderContainer.getLayoutParams().height*scale);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
        mHeaderContainer.setLayoutParams(layoutParams);
        Log.d("rq","height "+height);
    }

    public void setHeaderContainer(RelativeLayout relativeLayout, ImageView imageView){
        mHeaderContainer=relativeLayout;
        mHeaderImg=imageView;
        mHeaderHeight=mHeaderContainer.getLayoutParams().height;
        Log.e("rq",mHeaderContainer.getBottom()+" ");
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (firstVisibleItem == 0) {
            View firstVisibleItemView = getChildAt(0);
            if (firstVisibleItemView != null && firstVisibleItemView.getTop() == 0) {
                isOnTop=true;
            }else
                isOnTop=false;
        }else
            isOnTop=false;
    }
}
