package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.Checkable;

public final class j implements View.OnTouchListener {
    public final GestureDetector a;

    public j(GestureDetector gestureDetector0) {
        this.a = gestureDetector0;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        return ((Checkable)view0).isChecked() ? this.a.onTouchEvent(motionEvent0) : false;
    }
}

