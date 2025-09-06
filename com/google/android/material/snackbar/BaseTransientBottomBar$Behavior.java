package com.google.android.material.snackbar;

import B6.c;
import B6.f;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import w7.d;

public class BaseTransientBottomBar.Behavior extends SwipeDismissBehavior {
    public final d h;

    public BaseTransientBottomBar.Behavior() {
        d d0 = new d(7);
        this.e = 0.1f;
        this.f = 0.6f;
        this.d = 0;
        this.h = d0;
    }

    @Override  // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        this.h.getClass();
        switch(motionEvent0.getActionMasked()) {
            case 0: {
                if(coordinatorLayout0.n(view0, ((int)motionEvent0.getX()), ((int)motionEvent0.getY())) && f.b == null) {
                    f.b = new f(0);
                    return super.k(coordinatorLayout0, view0, motionEvent0);
                }
                break;
            }
            case 1: 
            case 3: {
                if(f.b == null) {
                    f.b = new f(0);
                    return super.k(coordinatorLayout0, view0, motionEvent0);
                }
                break;
            }
            default: {
                return super.k(coordinatorLayout0, view0, motionEvent0);
            }
        }
        return super.k(coordinatorLayout0, view0, motionEvent0);
    }

    @Override  // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean w(View view0) {
        this.h.getClass();
        return view0 instanceof c;
    }
}

