package com.google.android.material.timepicker;

import B6.f;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import c2.b;
import d2.d;

public final class c extends b {
    public final ClockFaceView a;

    public c(ClockFaceView clockFaceView0) {
        this.a = clockFaceView0;
        super();
    }

    @Override  // c2.b
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        int v = (int)(((Integer)view0.getTag(0x7F0A07EB)));  // id:material_value_index
        if(v > 0) {
            accessibilityNodeInfo0.setTraversalAfter(((View)this.a.I.get(v - 1)));
        }
        d0.n(f.c(0, 1, v, 1, false, view0.isSelected()));
        accessibilityNodeInfo0.setClickable(true);
        d0.b(d2.c.g);
    }

    @Override  // c2.b
    public final boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
        if(v == 16) {
            long v1 = SystemClock.uptimeMillis();
            view0.getHitRect(this.a.D);
            float f = (float)this.a.D.centerX();
            float f1 = (float)this.a.D.centerY();
            MotionEvent motionEvent0 = MotionEvent.obtain(v1, v1, 0, f, f1, 0);
            this.a.B.onTouchEvent(motionEvent0);
            MotionEvent motionEvent1 = MotionEvent.obtain(v1, v1, 1, f, f1, 0);
            this.a.B.onTouchEvent(motionEvent1);
            return true;
        }
        return super.performAccessibilityAction(view0, v, bundle0);
    }
}

