package com.kakao.emoticon.ui.widget;

import P1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import c2.M;
import c2.W;
import c2.q;
import c2.r;
import c2.u;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.R.layout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EmoticonPullToRefreshLayout extends ViewGroup implements q {
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    public static enum LoadingDrawbleType {
        CON(drawable.loading_store_con_anim),
        APEACH(drawable.loading_store_apeach_anim),
        TUBE(drawable.loading_store_tube_anim);

        private static final Random RANDOM;
        private static final int SIZE;
        private static final List VALUES;
        final int resId;

        static {
            List list0 = Collections.unmodifiableList(Arrays.asList(((LoadingDrawbleType[])LoadingDrawbleType.$VALUES.clone())));
            LoadingDrawbleType.VALUES = list0;
            LoadingDrawbleType.SIZE = list0.size();
            LoadingDrawbleType.RANDOM = new Random();
        }

        private LoadingDrawbleType(int v1) {
            this.resId = v1;
        }

        public static LoadingDrawbleType getRandomType() {
            int v = LoadingDrawbleType.RANDOM.nextInt(LoadingDrawbleType.SIZE);
            return (LoadingDrawbleType)LoadingDrawbleType.VALUES.get(v);
        }

        public int getResId() {
            return this.resId;
        }
    }

    public interface OnRefreshListener {
        void onRefresh(int arg1);
    }

    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    private static final int DEFAULT_CIRCLE_TARGET = 62;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_BOTTOM = 2;
    public static final int DIRECTION_NONE = 0;
    public static final int DIRECTION_TOP = 1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    private static final int[] LAYOUT_ATTRS;
    private boolean isDragRefresh;
    private int mActivePointerId;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleHeight;
    private int mCircleWidth;
    private int mCurrentDirection;
    private int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private int mDirection;
    protected int mFrom;
    private float mInitialDownX;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private OnRefreshListener mListener;
    private ProgressBar mLoadingView;
    private int mLoadingViewIndex;
    private final r mNestedScrollingChildHelper;
    private final u mNestedScrollingParentHelper;
    private boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentScrollConsumed;
    private final Animation.AnimationListener mRefreshListener;
    private boolean mRefreshing;
    private boolean mReturningToStart;
    private float mSpinnerFinalOffset;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private final int mTouchSlop;
    static LoadingDrawbleType sLoadingDrawbleType;

    static {
        EmoticonPullToRefreshLayout.LAYOUT_ATTRS = new int[]{0x101000E};
        EmoticonPullToRefreshLayout.sLoadingDrawbleType = LoadingDrawbleType.CON;
    }

    public EmoticonPullToRefreshLayout(Context context0) {
        this(context0, null);
    }

    public EmoticonPullToRefreshLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mDirection = 1;
        this.mCurrentDirection = 0;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mActivePointerId = -1;
        this.mLoadingViewIndex = -1;
        this.isDragRefresh = true;
        this.mRefreshListener = new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                if(EmoticonPullToRefreshLayout.this.mRefreshing) {
                    EmoticonPullToRefreshLayout.this.mLoadingView.setIndeterminate(true);
                    if(EmoticonPullToRefreshLayout.this.mNotify && EmoticonPullToRefreshLayout.this.mListener != null) {
                        EmoticonPullToRefreshLayout.this.mListener.onRefresh(EmoticonPullToRefreshLayout.this.mCurrentDirection);
                    }
                }
                else {
                    EmoticonPullToRefreshLayout.this.mLoadingView.setIndeterminate(false);
                    EmoticonPullToRefreshLayout.this.mLoadingView.setVisibility(8);
                    EmoticonPullToRefreshLayout.this.setTargetOffsetTopAndBottom(EmoticonPullToRefreshLayout.this.mOriginalOffsetTop - EmoticonPullToRefreshLayout.this.mCurrentTargetOffsetTop, true);
                }
                int v = EmoticonPullToRefreshLayout.this.mLoadingView.getTop();
                EmoticonPullToRefreshLayout.this.mCurrentTargetOffsetTop = v;
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
            }
        };
        this.mAnimateToCorrectPosition = new Animation() {
            @Override  // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation0) {
                int v;
                switch(EmoticonPullToRefreshLayout.this.mCurrentDirection) {
                    case 1: {
                        v = (int)(EmoticonPullToRefreshLayout.this.mSpinnerFinalOffset - ((float)Math.abs(EmoticonPullToRefreshLayout.this.mOriginalOffsetTop)));
                        break;
                    }
                    case 2: {
                        v = EmoticonPullToRefreshLayout.this.mOriginalOffsetTop - ((int)EmoticonPullToRefreshLayout.this.mSpinnerFinalOffset);
                        break;
                    }
                    default: {
                        return;
                    }
                }
                int v1 = EmoticonPullToRefreshLayout.this.mFrom + ((int)(((float)(v - EmoticonPullToRefreshLayout.this.mFrom)) * f));
                int v2 = EmoticonPullToRefreshLayout.this.mLoadingView.getTop();
                EmoticonPullToRefreshLayout.this.setTargetOffsetTopAndBottom(v1 - v2, false);
            }
        };
        this.mAnimateToStartPosition = new Animation() {
            @Override  // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation0) {
                EmoticonPullToRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context0).getScaledTouchSlop();
        this.setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, EmoticonPullToRefreshLayout.LAYOUT_ATTRS);
        this.setEnabled(typedArray0.getBoolean(0, true));
        typedArray0.recycle();
        this.createProgressView();
        if(W.b == null) {
            try {
                W.b = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", noSuchMethodException0);
            }
            W.b.setAccessible(true);
        }
        try {
            W.b.invoke(this, Boolean.TRUE);
        }
        catch(IllegalAccessException illegalAccessException0) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", illegalAccessException0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", illegalArgumentException0);
        }
        catch(InvocationTargetException invocationTargetException0) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", invocationTargetException0);
        }
        this.mNestedScrollingParentHelper = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.mNestedScrollingChildHelper = new r(this);
        this.setNestedScrollingEnabled(true);
    }

    private void animateOffsetToCorrectPosition(int v, Animation.AnimationListener animation$AnimationListener0) {
        this.mFrom = v;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if(animation$AnimationListener0 != null) {
            this.mAnimateToCorrectPosition.setAnimationListener(animation$AnimationListener0);
        }
        this.clearAnimation();
        this.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int v, Animation.AnimationListener animation$AnimationListener0) {
        this.mFrom = v;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        com.kakao.emoticon.ui.widget.EmoticonPullToRefreshLayout.2 emoticonPullToRefreshLayout$20 = new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                EmoticonPullToRefreshLayout.this.mReturningToStart = false;
                Animation.AnimationListener animation$AnimationListener0 = animation$AnimationListener0;
                if(animation$AnimationListener0 != null) {
                    animation$AnimationListener0.onAnimationEnd(animation0);
                }
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
                Animation.AnimationListener animation$AnimationListener0 = animation$AnimationListener0;
                if(animation$AnimationListener0 != null) {
                    animation$AnimationListener0.onAnimationRepeat(animation0);
                }
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                EmoticonPullToRefreshLayout.this.mReturningToStart = true;
                Animation.AnimationListener animation$AnimationListener0 = animation$AnimationListener0;
                if(animation$AnimationListener0 != null) {
                    animation$AnimationListener0.onAnimationStart(animation0);
                }
            }
        };
        this.mAnimateToStartPosition.setAnimationListener(emoticonPullToRefreshLayout$20);
        this.clearAnimation();
        this.startAnimation(this.mAnimateToStartPosition);
    }

    public boolean canChildScrollDown() {
        return this.mTarget.canScrollVertically(1);
    }

    public boolean canChildScrollUp() {
        return this.mTarget.canScrollVertically(-1);
    }

    private void createProgressView() {
        this.mLoadingView = (ProgressBar)View.inflate(this.getContext(), layout.emoticon_circle_progress, null);
        EmoticonPullToRefreshLayout.sLoadingDrawbleType = LoadingDrawbleType.getRandomType();
        Drawable drawable0 = c.getDrawable(this.getContext(), EmoticonPullToRefreshLayout.sLoadingDrawbleType.getResId());
        this.mLoadingView.setIndeterminateDrawable(drawable0);
        this.mLoadingView.setIndeterminate(false);
        this.mLoadingView.setVisibility(8);
        DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
        this.mCircleWidth = drawable0.getIntrinsicWidth();
        this.mCircleHeight = drawable0.getIntrinsicHeight();
        this.mSpinnerFinalOffset = displayMetrics0.density * 62.0f;
        this.mTotalDragDistance = displayMetrics0.density * 62.0f;
        this.addView(this.mLoadingView);
    }

    @Override  // android.view.View
    public boolean dispatchNestedFling(float f, float f1, boolean z) {
        return this.mNestedScrollingChildHelper.a(f, f1, z);
    }

    @Override  // android.view.View
    public boolean dispatchNestedPreFling(float f, float f1) {
        return this.mNestedScrollingChildHelper.b(f, f1);
    }

    @Override  // android.view.View
    public boolean dispatchNestedPreScroll(int v, int v1, int[] arr_v, int[] arr_v1) {
        return this.mNestedScrollingChildHelper.c(v, v1, arr_v, arr_v1, 0);
    }

    @Override  // android.view.View
    public boolean dispatchNestedScroll(int v, int v1, int v2, int v3, int[] arr_v) {
        return this.mNestedScrollingChildHelper.d(v, v1, v2, v3, arr_v, 0, null);
    }

    private void ensureTarget() {
        if(this.mTarget == null) {
            for(int v = 0; v < this.getChildCount(); ++v) {
                View view0 = this.getChildAt(v);
                if(!view0.equals(this.mLoadingView)) {
                    this.mTarget = view0;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f) {
        if(this.isDragRefresh && Math.abs(f) > Math.abs(this.mTotalDragDistance)) {
            this.setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mLoadingView.setProgress(0);
        this.mLoadingView.setTag(0);
        this.animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, null);
        this.setCurrentDirection(0);
    }

    @Override  // android.view.ViewGroup
    public int getChildDrawingOrder(int v, int v1) {
        int v2 = this.mLoadingViewIndex;
        if(v2 >= 0) {
            if(v1 == v - 1) {
                return v2;
            }
            return v1 < v2 ? v1 : v1 + 1;
        }
        return v1;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public LoadingDrawbleType getLoadingDrawbleType() {
        return EmoticonPullToRefreshLayout.sLoadingDrawbleType;
    }

    private float getMotionEventX(MotionEvent motionEvent0, int v) {
        int v1 = motionEvent0.findPointerIndex(v);
        return v1 >= 0 ? motionEvent0.getX(v1) : -1.0f;
    }

    private float getMotionEventY(MotionEvent motionEvent0, int v) {
        int v1 = motionEvent0.findPointerIndex(v);
        return v1 >= 0 ? motionEvent0.getY(v1) : -1.0f;
    }

    @Override  // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    public int getProgressCircleDiameter() {
        return this.mLoadingView == null ? 0 : this.mLoadingView.getMeasuredHeight();
    }

    @Override  // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.f(0);
    }

    @Override  // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.d;
    }

    public boolean isRefreshing(int v) {
        return this.mRefreshing;
    }

    private void moveLoadingViewToStart() {
        this.mLoadingView.bringToFront();
        this.mLoadingView.offsetTopAndBottom(this.mOriginalOffsetTop - this.mLoadingView.getTop());
        this.mCurrentTargetOffsetTop = this.mLoadingView.getTop();
        this.invalidate();
    }

    private void moveSpinner(float f) {
        int v1;
        float f1 = Math.min(1.0f, Math.abs(f / this.mTotalDragDistance));
        float f2 = this.mSpinnerFinalOffset;
        float f3 = Math.max(0.0f, Math.min(Math.abs(f) - this.mTotalDragDistance, f2 * 2.0f) / f2);
        float f4 = ((float)(((double)(f3 / 4.0f)) - Math.pow(f3 / 4.0f, 2.0))) * 2.0f * f2 * 2.0f;
        int v = this.mCurrentDirection;
        if(v == 1) {
            v1 = this.mOriginalOffsetTop + ((int)(f2 * f1 + f4));
            goto label_10;
        }
        else if(v == 2) {
            v1 = this.mOriginalOffsetTop - ((int)(f2 * f1 + f4));
        label_10:
            if(this.mLoadingView.getVisibility() != 0) {
                this.mLoadingView.setVisibility(0);
            }
            if(!this.mLoadingView.isIndeterminate()) {
                this.mLoadingView.setIndeterminate(true);
            }
            this.mLoadingView.setTag(((int)(f1 * 100.0f)));
            this.invalidate();
            this.setTargetOffsetTopAndBottom(v1 - this.mCurrentTargetOffsetTop, true);
        }
    }

    private void moveToStart(float f) {
        this.setTargetOffsetTopAndBottom(this.mFrom + ((int)(((float)(this.mOriginalOffsetTop - this.mFrom)) * f)) - this.mLoadingView.getTop(), false);
    }

    @Override  // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        this.ensureTarget();
        if(!this.mRefreshing && !this.mReturningToStart) {
            if(this.isEnabled() && (!this.canChildScrollUp() || !this.canChildScrollDown()) && (this.mDirection != 1 || !this.canChildScrollUp()) && (this.mDirection != 2 || !this.canChildScrollDown())) {
                int v = motionEvent0.getActionMasked();
                switch(v) {
                    case 0: {
                        int v1 = motionEvent0.getPointerId(0);
                        this.mActivePointerId = v1;
                        this.mIsBeingDragged = false;
                        float f = this.getMotionEventY(motionEvent0, v1);
                        this.mInitialDownX = this.getMotionEventX(motionEvent0, this.mActivePointerId);
                        if(f == -1.0f) {
                            return false;
                        }
                        this.mInitialDownY = f;
                        return this.mIsBeingDragged;
                    }
                    case 2: {
                        int v2 = this.mActivePointerId;
                        if(v2 == -1) {
                            return false;
                        }
                        float f1 = this.getMotionEventX(motionEvent0, v2);
                        float f2 = this.getMotionEventY(motionEvent0, this.mActivePointerId);
                        if(f2 == -1.0f) {
                            return false;
                        }
                        float f3 = f2 - this.mInitialDownY;
                        if(Math.abs(f3) < Math.abs(f1 - this.mInitialDownX)) {
                            return false;
                        }
                        if(Math.abs(f3) > ((float)this.mTouchSlop) && !this.mIsBeingDragged) {
                            if(f3 > 0.0f) {
                                int v3 = this.mDirection;
                                if(v3 == 2) {
                                    return false;
                                }
                                if(v3 == 3 && this.canChildScrollUp()) {
                                    return false;
                                }
                                this.setCurrentDirection(1);
                                this.mInitialMotionY = this.mInitialDownY + ((float)this.mTouchSlop);
                            }
                            else {
                                int v4 = this.mDirection;
                                if(v4 == 1) {
                                    return false;
                                }
                                if(v4 == 3 && this.canChildScrollDown()) {
                                    return false;
                                }
                                this.setCurrentDirection(2);
                                this.mInitialMotionY = this.mInitialDownY - ((float)this.mTouchSlop);
                            }
                            this.mIsBeingDragged = true;
                            return true;
                        }
                        break;
                    }
                    case 1: 
                    case 3: {
                        this.mIsBeingDragged = false;
                        this.mActivePointerId = -1;
                        return false;
                    label_18:
                        if(v == 6) {
                            this.onSecondaryPointerUp(motionEvent0);
                            return this.mIsBeingDragged;
                        }
                        break;
                    }
                    default: {
                        goto label_18;
                    }
                }
                return this.mIsBeingDragged;
            }
            return false;
        }
        return true;
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getMeasuredWidth();
        int v5 = this.getMeasuredHeight();
        if(this.getChildCount() != 0) {
            if(this.mTarget == null) {
                this.ensureTarget();
            }
            View view0 = this.mTarget;
            if(view0 != null) {
                int v6 = this.getPaddingLeft();
                int v7 = this.getPaddingTop() + this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop;
                view0.layout(v6, v7, v4 - this.getPaddingLeft() - this.getPaddingRight() + v6, v5 - this.getPaddingTop() - this.getPaddingBottom() + v7);
                int v8 = this.mLoadingView.getMeasuredWidth();
                int v9 = this.mLoadingView.getMeasuredHeight();
                if(this.getLoadingDrawbleType() == LoadingDrawbleType.APEACH || this.mRefreshing) {
                    this.mLoadingView.layout(v4 / 2 - v8 / 2, this.mCurrentTargetOffsetTop, v4 / 2 + v8 / 2, v9 + this.mCurrentTargetOffsetTop);
                }
                else if(this.mLoadingView.getTag() != null) {
                    float f = (float)(v4 - v8);
                    int v10 = (int)(f - (f - ((float)(v4 / 2 - v8 / 2))) / 100.0f * ((float)(((int)(((Integer)this.mLoadingView.getTag()))))));
                    this.mLoadingView.layout(v10, this.mCurrentTargetOffsetTop, v8 + v10, v9 + this.mCurrentTargetOffsetTop);
                }
            }
        }
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.mTarget == null) {
            this.ensureTarget();
        }
        View view0 = this.mTarget;
        if(view0 != null) {
            view0.measure(View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), 0x40000000), View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), 0x40000000));
            this.mLoadingView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleWidth, 0x40000000), View.MeasureSpec.makeMeasureSpec(this.mCircleHeight, 0x40000000));
            this.mLoadingViewIndex = -1;
            for(int v2 = 0; v2 < this.getChildCount(); ++v2) {
                if(this.getChildAt(v2) == this.mLoadingView) {
                    this.mLoadingViewIndex = v2;
                    return;
                }
            }
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedFling(View view0, float f, float f1, boolean z) {
        return false;
    }

    @Override  // android.view.ViewGroup
    public boolean onNestedPreFling(View view0, float f, float f1) {
        return false;
    }

    @Override  // android.view.ViewGroup
    public void onNestedPreScroll(View view0, int v, int v1, int[] arr_v) {
        if(v1 > 0) {
            float f = this.mTotalUnconsumed;
            if(f <= 0.0f) {
                goto label_10;
            }
            else if(((float)v1) > f) {
                arr_v[1] = v1 - ((int)f);
                this.mTotalUnconsumed = 0.0f;
                this.moveSpinner(this.mTotalUnconsumed);
            }
            else {
                this.mTotalUnconsumed = f - ((float)v1);
                arr_v[1] = v1;
                this.moveSpinner(this.mTotalUnconsumed);
            }
        }
        else {
        label_10:
            if(v1 < 0) {
                float f1 = this.mTotalUnconsumed;
                if(f1 < 0.0f) {
                    if(((float)v1) < f1) {
                        arr_v[1] = v1 - ((int)f1);
                        this.mTotalUnconsumed = 0.0f;
                    }
                    else {
                        this.mTotalUnconsumed = f1 - ((float)v1);
                        arr_v[1] = v1;
                    }
                    this.moveSpinner(this.mTotalUnconsumed);
                }
            }
        }
        int[] arr_v1 = this.mParentScrollConsumed;
        if(this.dispatchNestedPreScroll(v - arr_v[0], v1 - arr_v[1], arr_v1, null)) {
            arr_v[0] += arr_v1[0];
            arr_v[1] += arr_v1[1];
        }
    }

    @Override  // android.view.ViewGroup
    public void onNestedScroll(View view0, int v, int v1, int v2, int v3) {
        if(v3 < 0 && this.mDirection != 2) {
            this.mTotalUnconsumed += (float)Math.abs(v3);
            this.setCurrentDirection(1);
            this.moveSpinner(this.mTotalUnconsumed);
        }
        else if(v3 > 0 && this.mDirection != 1) {
            this.mTotalUnconsumed -= (float)v3;
            this.setCurrentDirection(2);
            this.moveSpinner(this.mTotalUnconsumed);
        }
        this.dispatchNestedScroll(v, v1, v2, v, null);
    }

    @Override  // android.view.ViewGroup
    public void onNestedScrollAccepted(View view0, View view1, int v) {
        this.mNestedScrollingParentHelper.a = v;
        this.mTotalUnconsumed = 0.0f;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionIndex();
        if(motionEvent0.getPointerId(v) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent0.getPointerId((v == 0 ? 1 : 0));
        }
    }

    @Override  // android.view.ViewGroup
    public boolean onStartNestedScroll(View view0, View view1, int v) {
        if(this.isEnabled() && (v & 2) != 0) {
            this.startNestedScroll(v & 2);
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public void onStopNestedScroll(View view0) {
        this.mNestedScrollingParentHelper.a = 0;
        if(Math.abs(this.mTotalUnconsumed) > 0.0f) {
            this.finishSpinner(this.mTotalUnconsumed);
            this.mTotalUnconsumed = 0.0f;
        }
        this.stopNestedScroll();
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        int v2;
        if(!this.mRefreshing && !this.mReturningToStart && this.isEnabled() && (this.mDirection != 1 || !this.canChildScrollUp()) && (this.mDirection != 2 || !this.canChildScrollDown())) {
            int v = motionEvent0.getActionMasked();
            if(v == 0) {
                this.mActivePointerId = motionEvent0.getPointerId(0);
                this.mIsBeingDragged = false;
            }
            else {
                switch(v) {
                    case 2: {
                        v2 = motionEvent0.findPointerIndex(this.mActivePointerId);
                        if(v2 < 0) {
                            return false;
                        }
                        break;
                    }
                    case 1: 
                    case 3: {
                        int v1 = this.mActivePointerId;
                        if(v1 == -1) {
                            return false;
                        }
                        float f = motionEvent0.getY(motionEvent0.findPointerIndex(v1));
                        this.mIsBeingDragged = false;
                        this.finishSpinner((f - this.mInitialMotionY) * 0.5f);
                        this.mActivePointerId = -1;
                        return false;
                    }
                    case 5: {
                        this.mActivePointerId = motionEvent0.getPointerId(motionEvent0.getActionIndex());
                        return true;
                    }
                    case 6: {
                        this.onSecondaryPointerUp(motionEvent0);
                        return true;
                    }
                    default: {
                        return true;
                    }
                }
                float f1 = (motionEvent0.getY(v2) - this.mInitialMotionY) * 0.5f;
                if(this.mIsBeingDragged) {
                    if(this.mCurrentDirection == 1 && f1 > 0.0f || this.mCurrentDirection == 2 && f1 < 0.0f) {
                        this.moveSpinner(f1);
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if(this.mTarget != null && !M.i(this.mTarget)) {
            return;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    private void setCurrentDirection(int v) {
        if(this.mCurrentDirection != v) {
            this.mCurrentDirection = v;
            if(v == 1 || v == 2) {
                int v1 = (int)((this.mSpinnerFinalOffset - ((float)this.mLoadingView.getMeasuredHeight())) / 2.0f);
                if(v == 1) {
                    int v2 = -this.mLoadingView.getMeasuredHeight() - v1;
                    this.mOriginalOffsetTop = v2;
                    this.mCurrentTargetOffsetTop = v2;
                    this.moveLoadingViewToStart();
                    return;
                }
                int v3 = this.getMeasuredHeight() + v1;
                this.mOriginalOffsetTop = v3;
                this.mCurrentTargetOffsetTop = v3;
                this.moveLoadingViewToStart();
            }
        }
    }

    public void setDirection(int v) {
        this.mDirection = v;
    }

    public void setDistanceToTriggerSync(int v) {
        this.mTotalDragDistance = (float)v;
    }

    public void setDragRefresh(boolean z) {
        this.isDragRefresh = z;
    }

    @Override  // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.g(z);
    }

    public void setOnRefreshListener(OnRefreshListener emoticonPullToRefreshLayout$OnRefreshListener0) {
        this.mListener = emoticonPullToRefreshLayout$OnRefreshListener0;
    }

    private void setRefreshing(boolean z, boolean z1) {
        if(this.mRefreshing != z) {
            this.mNotify = z1;
            this.ensureTarget();
            this.mRefreshing = z;
            if(z) {
                this.animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
                return;
            }
            this.animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
        }
    }

    private void setTargetOffsetTopAndBottom(int v, boolean z) {
        this.mLoadingView.bringToFront();
        this.mLoadingView.offsetTopAndBottom(v);
        this.mCurrentTargetOffsetTop = this.mLoadingView.getTop();
        this.mTarget.offsetTopAndBottom(v);
    }

    @Override  // android.view.View
    public boolean startNestedScroll(int v) {
        return this.mNestedScrollingChildHelper.h(v, 0);
    }

    public void startRefreshing(int v) {
        if(!this.mRefreshing) {
            this.mRefreshing = true;
            this.setCurrentDirection(v);
            this.setTargetOffsetTopAndBottom(((int)(this.mSpinnerFinalOffset + ((float)this.mOriginalOffsetTop))) - this.mCurrentTargetOffsetTop, true);
            this.mNotify = false;
            this.mLoadingView.setVisibility(0);
            this.mRefreshListener.onAnimationEnd(null);
        }
    }

    @Override  // android.view.View
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.i(0);
    }

    public void stopRefreshing() {
        if(this.mRefreshing) {
            this.setRefreshing(false, false);
        }
    }
}

