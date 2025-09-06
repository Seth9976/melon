package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, Listener {
    interface com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener {
        void onScrollChange(PointF arg1);
    }

    static final float MAX_PITCH_DEGREES = 45.0f;
    private final PointF accumulatedTouchOffsetDegrees;
    private final GestureDetector gestureDetector;
    private final com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener listener;
    private final PointF previousTouchPointPx;
    private final float pxPerDegrees;
    private volatile float roll;
    private SingleTapListener singleTapListener;

    public TouchTracker(Context context0, com.google.android.exoplayer2.ui.spherical.TouchTracker.Listener touchTracker$Listener0, float f) {
        this.previousTouchPointPx = new PointF();
        this.accumulatedTouchOffsetDegrees = new PointF();
        this.listener = touchTracker$Listener0;
        this.pxPerDegrees = f;
        this.gestureDetector = new GestureDetector(context0, this);
        this.roll = 3.141593f;
    }

    @Override  // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onDown(MotionEvent motionEvent0) {
        float f = motionEvent0.getX();
        float f1 = motionEvent0.getY();
        this.previousTouchPointPx.set(f, f1);
        return true;
    }

    @Override  // com.google.android.exoplayer2.ui.spherical.OrientationListener$Listener
    public void onOrientationChange(float[] arr_f, float f) {
        this.roll = -f;
    }

    @Override  // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onScroll(MotionEvent motionEvent0, MotionEvent motionEvent1, float f, float f1) {
        float f2 = (motionEvent1.getX() - this.previousTouchPointPx.x) / this.pxPerDegrees;
        float f3 = (motionEvent1.getY() - this.previousTouchPointPx.y) / this.pxPerDegrees;
        float f4 = motionEvent1.getX();
        float f5 = motionEvent1.getY();
        this.previousTouchPointPx.set(f4, f5);
        float f6 = (float)Math.cos(this.roll);
        float f7 = (float)Math.sin(this.roll);
        this.accumulatedTouchOffsetDegrees.x -= f6 * f2 - f7 * f3;
        this.accumulatedTouchOffsetDegrees.y = Math.max(-45.0f, Math.min(45.0f, f6 * f3 + f7 * f2 + this.accumulatedTouchOffsetDegrees.y));
        this.listener.onScrollChange(this.accumulatedTouchOffsetDegrees);
        return true;
    }

    @Override  // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent0) {
        return this.singleTapListener == null ? false : this.singleTapListener.onSingleTapUp(motionEvent0);
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        return this.gestureDetector.onTouchEvent(motionEvent0);
    }

    public void setSingleTapListener(SingleTapListener singleTapListener0) {
        this.singleTapListener = singleTapListener0;
    }
}

