package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public class WrapContentHeightViewPager extends NonSwipeableViewPager {
    private static final String TAG = "WrapContentHeightViewPager";
    private boolean mIsVScrolled;
    private int mOrgPointY;
    private int mPointX;
    private int mPointY;
    private int mTouchSlop;

    public WrapContentHeightViewPager(Context context0) {
        super(context0);
        this.mIsVScrolled = false;
        this.initView();
    }

    public WrapContentHeightViewPager(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mIsVScrolled = false;
        this.initView();
    }

    private void initView() {
        this.mTouchSlop = ViewConfiguration.get(this.getContext()).getScaledPagingTouchSlop();
    }

    @Override  // android.support.v4.view.NonSwipeableViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 0: {
                this.mPointX = (int)motionEvent0.getX();
                this.mPointY = (int)motionEvent0.getY();
                this.mOrgPointY = (int)motionEvent0.getY();
                this.mIsVScrolled = false;
                this.requestParentDisallowInterceptTouchEvent(true);
                return super.onInterceptTouchEvent(motionEvent0);
            }
            case 2: {
                if(!this.mIsVScrolled) {
                    int v = (int)motionEvent0.getX();
                    int v1 = (int)motionEvent0.getY();
                    int v2 = Math.abs(this.mPointX - v);
                    int v3 = Math.abs(this.mPointY - v1);
                    if(Math.abs(this.mOrgPointY - v1) > this.mTouchSlop && v2 < v3 || ((double)v2) < ((double)v3) * 0.5) {
                        this.requestParentDisallowInterceptTouchEvent(false);
                        this.mIsVScrolled = true;
                        return super.onInterceptTouchEvent(motionEvent0);
                    }
                    this.mPointX = v;
                    this.mPointY = v1;
                    return super.onInterceptTouchEvent(motionEvent0);
                }
                return super.onInterceptTouchEvent(motionEvent0);
            }
            default: {
                return super.onInterceptTouchEvent(motionEvent0);
            }
        }
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public void onMeasure(int v, int v1) {
        if(this.getChildCount() > 0) {
            View view0 = this.getChildAt(0);
            if(view0 != null) {
                view0.measure(v, v1);
                int v2 = view0.getMeasuredHeight();
                int v3 = this.getPaddingTop();
                v1 = View.MeasureSpec.makeMeasureSpec(this.getPaddingBottom() + (v3 + v2), 0x40000000);
            }
        }
        super.onMeasure(v, v1);
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent viewParent0 = this.getParent();
        if(viewParent0 != null) {
            viewParent0.requestDisallowInterceptTouchEvent(z);
        }
    }
}

