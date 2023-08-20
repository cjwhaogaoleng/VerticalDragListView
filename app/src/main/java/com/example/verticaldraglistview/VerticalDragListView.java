package com.example.verticaldraglistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ListViewCompat;
import androidx.customview.widget.ViewDragHelper;

public class VerticalDragListView extends FrameLayout {

    private ViewDragHelper mDragHelper;
    private View mDragListView;
    //菜单高度
    private int mMenuHeight;
    private boolean mMenuIsOpen = false;

    public VerticalDragListView(@NonNull Context context) {
        this(context,null);
    }

    public VerticalDragListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalDragListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDragHelper = ViewDragHelper.create(this, mDragHelperCallback);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        int childCount = getChildCount();
        if (childCount != 2) {
            throw new RuntimeException("VerticalDragListView只能包含两个子布局");
        }
        mDragListView = getChildAt(1);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mMenuHeight = getChildAt(0).getMeasuredHeight();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    private ViewDragHelper.Callback mDragHelperCallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            //指定该子view是否可以拖动
            //只能列表拖动

            return mDragListView == child;
        }

        /**
         * 限制拖动范围
         */
        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            //垂直拖动移动的位置
            if (top <= 0) {
                top = 0;
            }
            if (top >= mMenuHeight) {
                top = mMenuHeight;
            }
            return top;
        }

        /**
         * 松开后自动弹回
         */
        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
            //列表布局的最顶端
            if (mDragListView.getTop() > mMenuHeight / 2) {
                //滚动的菜单的高度（open）
                mDragHelper.settleCapturedViewAt(0, mMenuHeight);
                mMenuIsOpen = true;

            } else {
                //滚动到0的位置（close）
                mDragHelper.settleCapturedViewAt(0, 0);
                mMenuIsOpen = false;

            }
            invalidate();
        }


    };

    //down时的y坐标
    private float mDownY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //向下滑动拦截，不给recycleView处理

        //getParent().requestDisallowInterceptTouchEvent(true);请求父view不要拦截

        //向上滑动的时候(菜单完全打开的时候)，全部拦截
        if (mMenuIsOpen) {
            return true;
        }

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownY = ev.getY();
                mDragHelper.processTouchEvent(ev);
                break;
            case MotionEvent.ACTION_MOVE:
                Float moveY = ev.getY();
                //向下滑动，并且滚动到了list的最顶部，再拦截，让本父view处理
                if (moveY- mDownY > 0 && !canChildScrollUp()) {
                    //向下滑动，不让ListView处理
                    return true;
                }
        }

        return super.onInterceptTouchEvent(ev);

    }

    /**
     * 判断listView是否滚动到了最顶部
     * Returns:
     * Whether it is possible for the child view of this layout to scroll up.
     * Override this if the child view is a custom view.
     */
    public boolean canChildScrollUp() {
        if (mDragListView instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) mDragListView, -1);
        }
        return mDragListView.canScrollVertically(-1);
    }



    /**
     * 响应滚动
     */
    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            invalidate();
        }
    }
}
