package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class InnerChildViewPager extends WrapContentHeightLoopViewPager {
    private static final String TAG = "ChildViewPager";
    private int mStartedPointY;
    private int mTouchSlop;

    public InnerChildViewPager(Context context0) {
        super(context0);
        this.initView();
    }

    public InnerChildViewPager(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.initView();
    }

    private void initView() {
        this.mTouchSlop = ViewConfiguration.get(this.getContext()).getScaledPagingTouchSlop() / 2;
    }

    @Override  // android.support.v4.view.WrapContentHeightViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 0: {
                this.mStartedPointY = (int)motionEvent0.getY();
                return super.onInterceptTouchEvent(motionEvent0);
            }
            case 2: {
                if(Math.abs(this.mStartedPointY - ((int)motionEvent0.getY())) > this.mTouchSlop) {
                    this.getParent().requestDisallowInterceptTouchEvent(false);
                    return true;
                }
                this.getParent().requestDisallowInterceptTouchEvent(true);
                return super.onInterceptTouchEvent(motionEvent0);
            }
            default: {
                return super.onInterceptTouchEvent(motionEvent0);
            }
        }
    }
}

