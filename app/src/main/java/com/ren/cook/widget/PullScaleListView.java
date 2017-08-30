package com.ren.cook.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
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

public class PullScaleListView extends ListView implements AbsListView.OnScrollListener,GestureDetector.OnGestureListener {

    private boolean isOnTop=false;
    private boolean scaleing=false;
    /*头部View 的容器*/
    private RelativeLayout mHeaderContainer;
    /*头部View 的图片*/
    private ImageView mHeaderImg;

    private int mHeaderHeight;

    private GestureDetector gestureDetector;

    public PullScaleListView(Context context) {
        super(context);
        init(context);
    }

    public PullScaleListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PullScaleListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        setOnScrollListener(this);
        gestureDetector=new GestureDetector(context, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_UP :
                scaleing=false;
                reset();
                break;
        }
        return  gestureDetector.onTouchEvent(ev);
    }

    private void scaleBigImage(float offY){
        int height= (int) (mHeaderContainer.getLayoutParams().height+(offY/5));
        if (height<mHeaderHeight)
            return;
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
        mHeaderContainer.setLayoutParams(layoutParams);
        Log.d("rq","scaleBigImage height "+height);
    }

    public void setHeaderContainer(RelativeLayout relativeLayout, ImageView imageView){
        mHeaderContainer=relativeLayout;
        mHeaderImg=imageView;
        mHeaderHeight=mHeaderContainer.getLayoutParams().height;
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

    @Override
    public boolean onDown(MotionEvent e) {
        return  super.onTouchEvent(e);
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return  super.onTouchEvent(e);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (scaleing){
            scaleBigImage(-distanceY);
            return true;
        }
        if (isOnTop){
            if (distanceY<0){
                scaleing=true ;
                return true;
            }else
                return  super.onTouchEvent(e2);
        }else
            return  super.onTouchEvent(e2);
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return  super.onTouchEvent(e2);
    }

    //释放手指后实现回弹效果
    private void reset() {
        ValueAnimator animator;// 动画器
        animator = ValueAnimator.ofInt(mHeaderContainer.getLayoutParams().height,mHeaderHeight);// 动画更新的监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator arg0) {
                Integer height = (Integer) arg0.getAnimatedValue();// 获取动画当前变化的值
                // 根据最新高度,更新布局高度
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
                mHeaderContainer.setLayoutParams(layoutParams);
            }
        });
        animator.setDuration(100);// 动画时间
        animator.start();// 开启动画
    }
}
