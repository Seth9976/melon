package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c2.W;
import com.iloen.melon.custom.S0;
import g6.a;
import j2.c;

public class SwipeDismissBehavior extends Behavior {
    public c a;
    public boolean b;
    public boolean c;
    public int d;
    public float e;
    public float f;
    public final a g;

    public SwipeDismissBehavior() {
        this.d = 2;
        this.e = 0.0f;
        this.f = 0.5f;
        this.g = new a(this);
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        boolean z = this.b;
        int v = motionEvent0.getActionMasked();
        switch(v) {
            case 0: {
                z = coordinatorLayout0.n(view0, ((int)motionEvent0.getX()), ((int)motionEvent0.getY()));
                this.b = z;
                break;
            }
            case 1: {
                this.b = false;
                break;
            }
            default: {
                if(v == 3) {
                    this.b = false;
                }
            }
        }
        if(z) {
            if(this.a == null) {
                this.a = new c(coordinatorLayout0.getContext(), coordinatorLayout0, this.g);
            }
            return !this.c && this.a.t(motionEvent0);
        }
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        if(view0.getImportantForAccessibility() == 0) {
            view0.setImportantForAccessibility(1);
            W.l(view0, 0x100000);
            W.i(view0, 0);
            if(this.w(view0)) {
                S0 s00 = new S0(this, 12);
                W.m(view0, d2.c.n, null, s00);
            }
        }
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        if(this.a != null) {
            if(!this.c || motionEvent0.getActionMasked() != 3) {
                this.a.m(motionEvent0);
            }
            return true;
        }
        return false;
    }

    public boolean w(View view0) {
        return true;
    }
}

