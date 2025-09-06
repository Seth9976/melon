package com.kakao.emoticon.ui.tab;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z0;
import androidx.viewpager.widget.ViewPager;

public class TabTouchListener implements z0 {
    private boolean isContentViewTouch;
    private ViewPager tabContentView;
    private int tabContentViewHeight;
    private int tabContentViewWidth;
    private int tabContentViewX;
    private int tabContentViewY;

    public TabTouchListener(ViewPager viewPager0) {
        this.isContentViewTouch = false;
        this.tabContentView = viewPager0;
    }

    private boolean isContentViewContains(float f, float f1) {
        if(this.tabContentView != null && this.tabContentView.getAdapter() != null && this.tabContentView.getAdapter().getCount() > 0) {
            if(this.tabContentViewWidth <= 0) {
                int[] arr_v = new int[2];
                this.tabContentView.getLocationOnScreen(arr_v);
                this.tabContentViewX = arr_v[0];
                this.tabContentViewY = arr_v[1];
                this.tabContentViewWidth = this.tabContentView.getWidth();
                this.tabContentViewHeight = this.tabContentView.getHeight();
            }
            return f >= ((float)this.tabContentViewX) && f <= ((float)(this.tabContentViewX + this.tabContentViewWidth)) && (f1 >= ((float)this.tabContentViewY) && f1 <= ((float)(this.tabContentViewY + this.tabContentViewHeight)));
        }
        return false;
    }

    public boolean isContentViewTouch() {
        return this.isContentViewTouch;
    }

    @Override  // androidx.recyclerview.widget.z0
    public boolean onInterceptTouchEvent(RecyclerView recyclerView0, MotionEvent motionEvent0) {
        try {
            if(motionEvent0.getAction() == 0) {
                this.isContentViewTouch = this.isContentViewContains(motionEvent0.getRawX(), motionEvent0.getRawY());
            }
            if(this.isContentViewTouch) {
                MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
                motionEvent1.offsetLocation(0.0f, ((float)(-this.tabContentView.getTop())));
                this.tabContentView.dispatchTouchEvent(motionEvent1);
                return false;
            }
        }
        catch(Exception unused_ex) {
            return motionEvent0.getAction() == 0 && (this.tabContentViewY > 0 && ((float)this.tabContentViewY) < motionEvent0.getRawY());
        }
        return motionEvent0.getAction() == 0 && (this.tabContentViewY > 0 && ((float)this.tabContentViewY) < motionEvent0.getRawY());
    }

    @Override  // androidx.recyclerview.widget.z0
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override  // androidx.recyclerview.widget.z0
    public void onTouchEvent(RecyclerView recyclerView0, MotionEvent motionEvent0) {
    }

    public void reset() {
        this.tabContentViewWidth = 0;
        this.tabContentViewHeight = 0;
        this.tabContentViewX = 0;
        this.tabContentViewY = 0;
    }
}

