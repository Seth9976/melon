package com.google.android.material.timepicker;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public final class i extends GestureDetector.SimpleOnGestureListener {
    public final TimePickerView a;

    public i(TimePickerView timePickerView0) {
        this.a = timePickerView0;
        super();
    }

    @Override  // android.view.GestureDetector$SimpleOnGestureListener
    public final boolean onDoubleTap(MotionEvent motionEvent0) {
        this.a.getClass();
        return false;
    }
}

