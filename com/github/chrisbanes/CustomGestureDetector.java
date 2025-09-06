package com.github.chrisbanes;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class CustomGestureDetector {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId;
    private int mActivePointerIndex;
    private final ScaleGestureDetector mDetector;
    private boolean mIsDragging;
    private float mLastTouchX;
    private float mLastTouchY;
    private OnGestureListener mListener;
    private final float mMinimumVelocity;
    private final float mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public CustomGestureDetector(Context context0, OnGestureListener onGestureListener0) {
        this.mActivePointerId = -1;
        this.mActivePointerIndex = 0;
        ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
        this.mMinimumVelocity = (float)viewConfiguration0.getScaledMinimumFlingVelocity();
        this.mTouchSlop = (float)viewConfiguration0.getScaledTouchSlop();
        this.mListener = onGestureListener0;
        this.mDetector = new ScaleGestureDetector(context0, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override  // android.view.ScaleGestureDetector$OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector0) {
                float f = scaleGestureDetector0.getScaleFactor();
                if(!Float.isNaN(f) && !Float.isInfinite(f)) {
                    if(f >= 0.0f) {
                        float f1 = scaleGestureDetector0.getFocusX();
                        float f2 = scaleGestureDetector0.getFocusY();
                        CustomGestureDetector.a(CustomGestureDetector.this).onScale(f, f1, f2);
                    }
                    return true;
                }
                return false;
            }

            @Override  // android.view.ScaleGestureDetector$OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector0) {
                return true;
            }

            @Override  // android.view.ScaleGestureDetector$OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector0) {
            }
        });
    }

    public static OnGestureListener a(CustomGestureDetector customGestureDetector0) {
        return customGestureDetector0.mListener;
    }

    private float getActiveX(MotionEvent motionEvent0) {
        try {
            return motionEvent0.getX(this.mActivePointerIndex);
        }
        catch(Exception unused_ex) {
            return motionEvent0.getX();
        }
    }

    private float getActiveY(MotionEvent motionEvent0) {
        try {
            return motionEvent0.getY(this.mActivePointerIndex);
        }
        catch(Exception unused_ex) {
            return motionEvent0.getY();
        }
    }

    private static int getPointerIndex(int v) {
        return (v & 0xFF00) >> 8;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public boolean isScaling() {
        return this.mDetector.isInProgress();
    }

    public boolean onTouchEvent(MotionEvent motionEvent0) {
        try {
            this.mDetector.onTouchEvent(motionEvent0);
            return this.processTouchEvent(motionEvent0);
        }
        catch(IllegalArgumentException unused_ex) {
            return true;
        }
    }

    private boolean processTouchEvent(MotionEvent motionEvent0) {
        int v = 0;
        switch(motionEvent0.getAction() & 0xFF) {
            case 0: {
                this.mActivePointerId = motionEvent0.getPointerId(0);
                VelocityTracker velocityTracker0 = VelocityTracker.obtain();
                this.mVelocityTracker = velocityTracker0;
                if(velocityTracker0 != null) {
                    velocityTracker0.addMovement(motionEvent0);
                }
                this.mLastTouchX = this.getActiveX(motionEvent0);
                this.mLastTouchY = this.getActiveY(motionEvent0);
                this.mIsDragging = false;
                break;
            }
            case 1: {
                this.mActivePointerId = -1;
                if(this.mIsDragging && this.mVelocityTracker != null) {
                    this.mLastTouchX = this.getActiveX(motionEvent0);
                    this.mLastTouchY = this.getActiveY(motionEvent0);
                    this.mVelocityTracker.addMovement(motionEvent0);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float f = this.mVelocityTracker.getXVelocity();
                    float f1 = this.mVelocityTracker.getYVelocity();
                    if(Math.max(Math.abs(f), Math.abs(f1)) >= this.mMinimumVelocity) {
                        this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -f, -f1);
                    }
                }
                VelocityTracker velocityTracker1 = this.mVelocityTracker;
                if(velocityTracker1 != null) {
                    velocityTracker1.recycle();
                    this.mVelocityTracker = null;
                }
                break;
            }
            case 2: {
                float f2 = this.getActiveX(motionEvent0);
                float f3 = this.getActiveY(motionEvent0);
                float f4 = f2 - this.mLastTouchX;
                float f5 = f3 - this.mLastTouchY;
                if(!this.mIsDragging) {
                    this.mIsDragging = Math.sqrt(f5 * f5 + f4 * f4) >= ((double)this.mTouchSlop);
                }
                if(this.mIsDragging) {
                    this.mListener.onDrag(f4, f5);
                    this.mLastTouchX = f2;
                    this.mLastTouchY = f3;
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    if(velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent0);
                    }
                }
                break;
            }
            case 3: {
                this.mActivePointerId = -1;
                VelocityTracker velocityTracker3 = this.mVelocityTracker;
                if(velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.mVelocityTracker = null;
                }
                break;
            }
            case 6: {
                int v1 = CustomGestureDetector.getPointerIndex(motionEvent0.getAction());
                if(motionEvent0.getPointerId(v1) == this.mActivePointerId) {
                    int v2 = v1 == 0 ? 1 : 0;
                    this.mActivePointerId = motionEvent0.getPointerId(v2);
                    this.mLastTouchX = motionEvent0.getX(v2);
                    this.mLastTouchY = motionEvent0.getY(v2);
                }
            }
        }
        int v3 = this.mActivePointerId;
        if(v3 != -1) {
            v = v3;
        }
        this.mActivePointerIndex = motionEvent0.findPointerIndex(v);
        return true;
    }
}

