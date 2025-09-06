package com.iloen.melon.custom;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

public abstract class GestureTouchListener implements View.OnTouchListener {
    private static final String TAG = "GestureTouchListener";
    private GestureDetector mGestureDetector;

    public GestureTouchListener(Context context0) {
        this.mGestureDetector = new GestureDetector(context0, new N(this));
    }

    public abstract void onSingleTouchUp();

    public abstract void onSwipeBottom();

    public abstract void onSwipeLeft();

    public abstract void onSwipeRight();

    public abstract void onSwipeTop();

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        return this.mGestureDetector.onTouchEvent(motionEvent0);
    }
}

