package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.viewpager.widget.ViewPager;
import com.iloen.melon.utils.log.LogU;

public class NonSwipeableViewPager extends ViewPager {
    private static final String TAG = "NonSwipeableViewPager";
    private boolean isPagingEnabled;
    private boolean mCanScrollLeft;
    private boolean mCanScrollRight;
    private boolean mIsStartTouchDown;
    private int mStartedPointX;

    public NonSwipeableViewPager(Context context0) {
        super(context0);
        this.isPagingEnabled = true;
        this.mCanScrollLeft = true;
        this.mCanScrollRight = true;
    }

    public NonSwipeableViewPager(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.isPagingEnabled = true;
        this.mCanScrollLeft = true;
        this.mCanScrollRight = true;
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view0, boolean z, int v, int v1, int v2) {
        if(view0 instanceof WebView) {
            return this.isPagingEnabled && super.canScroll(view0, z, v, v1, v2);
        }
        this.isPagingEnabled = true;
        return super.canScroll(view0, z, v, v1, v2);
    }

    public void enableSwipe(boolean z, boolean z1) {
        this.mCanScrollLeft = z;
        this.mCanScrollRight = z1;
        LogU.d("NonSwipeableViewPager", "enableSwipe - left:" + z + ", right:" + z1);
    }

    public boolean isEnabledLeftSwipe() {
        return this.mCanScrollLeft;
    }

    public boolean isEnabledRightSwipe() {
        return this.mCanScrollRight;
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        if(this.shouldInterceptTouchEvent(motionEvent0, 1)) {
            return false;
        }
        try {
            if(this.isPagingEnabled && super.onInterceptTouchEvent(motionEvent0)) {
                return true;
            }
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            illegalArgumentException0.printStackTrace();
        }
        return false;
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.shouldInterceptTouchEvent(motionEvent0, 0)) {
            return false;
        }
        try {
            if(this.isPagingEnabled && super.onTouchEvent(motionEvent0)) {
                return true;
            }
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            illegalArgumentException0.printStackTrace();
        }
        return false;
    }

    public void setPagingEnabled(boolean z) {
        this.isPagingEnabled = z;
    }

    private boolean shouldInterceptTouchEvent(MotionEvent motionEvent0, int v) {
        int v1 = motionEvent0.getAction();
        switch(v1) {
            case 0: {
                this.mStartedPointX = (int)motionEvent0.getX();
                this.mIsStartTouchDown = true;
                break;
            }
            case 1: {
                this.mIsStartTouchDown = false;
                return false;
            label_5:
                if(v1 == 2) {
                    int v2 = (int)motionEvent0.getX();
                    if(this.mIsStartTouchDown) {
                        return this.mCanScrollLeft || this.mStartedPointX - v2 >= 0 ? !this.mCanScrollRight && this.mStartedPointX - v2 > 0 : true;
                    }
                }
                break;
            }
            default: {
                goto label_5;
            }
        }
        return false;
    }
}

