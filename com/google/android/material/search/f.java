package com.google.android.material.search;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import com.google.android.material.textfield.h;

public final class f implements View.OnTouchListener {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        Object object0 = this.b;
        if(this.a != 0) {
            if(motionEvent0.getAction() == 1) {
                long v = System.currentTimeMillis() - ((h)object0).o;
                if(v < 0L || v > 300L) {
                    ((h)object0).m = false;
                }
                ((h)object0).u();
                ((h)object0).m = true;
                ((h)object0).o = System.currentTimeMillis();
            }
            return false;
        }
        if(((SearchView)object0).g()) {
            ((SearchView)object0).f();
        }
        return false;
    }
}

