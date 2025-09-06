package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class LinearSmoothScroller extends J0 {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    protected final DecelerateInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel;
    protected int mInterimTargetDx;
    protected int mInterimTargetDy;
    protected final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;
    @SuppressLint({"UnknownNullness"})
    protected PointF mTargetVector;

    @SuppressLint({"UnknownNullness"})
    public LinearSmoothScroller(Context context0) {
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = context0.getResources().getDisplayMetrics();
    }

    public int calculateDtToFit(int v, int v1, int v2, int v3, int v4) {
        switch(v4) {
            case -1: {
                return v2 - v;
            }
            case 0: {
                int v5 = v2 - v;
                if(v5 > 0) {
                    return v5;
                }
                int v6 = v3 - v1;
                return v6 >= 0 ? 0 : v6;
            }
            default: {
                if(v4 != 1) {
                    throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
                }
                return v3 - v1;
            }
        }
    }

    public int calculateDxToMakeVisible(View view0, int v) {
        w0 w00 = this.getLayoutManager();
        if(w00 != null && w00.canScrollHorizontally()) {
            LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            return this.calculateDtToFit(w00.getDecoratedLeft(view0) - recyclerView$LayoutParams0.leftMargin, w00.getDecoratedRight(view0) + recyclerView$LayoutParams0.rightMargin, w00.getPaddingLeft(), w00.getWidth() - w00.getPaddingRight(), v);
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public int calculateDyToMakeVisible(View view0, int v) {
        w0 w00 = this.getLayoutManager();
        if(w00 != null && w00.canScrollVertically()) {
            LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            return this.calculateDtToFit(w00.getDecoratedTop(view0) - recyclerView$LayoutParams0.topMargin, w00.getDecoratedBottom(view0) + recyclerView$LayoutParams0.bottomMargin, w00.getPaddingTop(), w00.getHeight() - w00.getPaddingBottom(), v);
        }
        return 0;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics0) {
        return 25.0f / ((float)displayMetrics0.densityDpi);
    }

    public int calculateTimeForDeceleration(int v) {
        return (int)Math.ceil(((double)this.calculateTimeForScrolling(v)) / 0.3356);
    }

    public int calculateTimeForScrolling(int v) {
        float f = (float)Math.abs(v);
        if(!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = this.calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return (int)Math.ceil(f * this.mMillisPerPixel);
    }

    public int getHorizontalSnapPreference() {
        PointF pointF0 = this.mTargetVector;
        if(pointF0 != null) {
            float f = pointF0.x;
            if(f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF pointF0 = this.mTargetVector;
        if(pointF0 != null) {
            float f = pointF0.y;
            if(f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    @Override  // androidx.recyclerview.widget.J0
    @SuppressLint({"UnknownNullness"})
    public void onSeekTargetStep(int v, int v1, K0 k00, H0 h00) {
        if(this.getChildCount() == 0) {
            this.stop();
            return;
        }
        int v2 = this.mInterimTargetDx - v;
        int v3 = 0;
        if(this.mInterimTargetDx * v2 <= 0) {
            v2 = 0;
        }
        this.mInterimTargetDx = v2;
        int v4 = this.mInterimTargetDy - v1;
        if(this.mInterimTargetDy * v4 > 0) {
            v3 = v4;
        }
        this.mInterimTargetDy = v3;
        if(v2 == 0 && v3 == 0) {
            this.updateActionForInterimTarget(h00);
        }
    }

    @Override  // androidx.recyclerview.widget.J0
    public void onStart() {
    }

    @Override  // androidx.recyclerview.widget.J0
    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    @Override  // androidx.recyclerview.widget.J0
    @SuppressLint({"UnknownNullness"})
    public void onTargetFound(View view0, K0 k00, H0 h00) {
        int v = this.calculateDxToMakeVisible(view0, this.getHorizontalSnapPreference());
        int v1 = this.calculateDyToMakeVisible(view0, this.getVerticalSnapPreference());
        int v2 = this.calculateTimeForDeceleration(((int)Math.sqrt(v1 * v1 + v * v)));
        if(v2 > 0) {
            h00.a = -v;
            h00.b = -v1;
            h00.c = v2;
            h00.e = this.mDecelerateInterpolator;
            h00.f = true;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void updateActionForInterimTarget(H0 h00) {
        PointF pointF0 = this.computeScrollVectorForPosition(this.getTargetPosition());
        if(pointF0 != null && (pointF0.x != 0.0f || pointF0.y != 0.0f)) {
            this.normalize(pointF0);
            this.mTargetVector = pointF0;
            this.mInterimTargetDx = (int)(pointF0.x * 10000.0f);
            this.mInterimTargetDy = (int)(pointF0.y * 10000.0f);
            int v = this.calculateTimeForScrolling(10000);
            h00.a = (int)(((float)this.mInterimTargetDx) * 1.2f);
            h00.b = (int)(((float)this.mInterimTargetDy) * 1.2f);
            h00.c = (int)(((float)v) * 1.2f);
            h00.e = this.mLinearInterpolator;
            h00.f = true;
            return;
        }
        h00.d = this.getTargetPosition();
        this.stop();
    }
}

