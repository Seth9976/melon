package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public final class q0 implements Runnable {
    public final int a;
    public final r0 b;

    public q0(r0 r00, int v) {
        this.a = v;
        this.b = r00;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            r0 r00 = this.b;
            r00.a();
            View view0 = r00.d;
            if(view0.isEnabled() && !view0.isLongClickable() && r00.c()) {
                view0.getParent().requestDisallowInterceptTouchEvent(true);
                long v = SystemClock.uptimeMillis();
                MotionEvent motionEvent0 = MotionEvent.obtain(v, v, 3, 0.0f, 0.0f, 0);
                view0.onTouchEvent(motionEvent0);
                motionEvent0.recycle();
                r00.g = true;
            }
            return;
        }
        ViewParent viewParent0 = this.b.d.getParent();
        if(viewParent0 != null) {
            viewParent0.requestDisallowInterceptTouchEvent(true);
        }
    }
}

