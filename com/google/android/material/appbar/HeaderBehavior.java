package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

abstract class HeaderBehavior extends ViewOffsetBehavior {
    public h c;
    public OverScroller d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public VelocityTracker i;

    public HeaderBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.f = -1;
        this.h = -1;
    }

    public boolean A(View view0) {
        return false;
    }

    public int B(View view0) {
        return -view0.getHeight();
    }

    public int C(View view0) {
        return view0.getHeight();
    }

    public void D(CoordinatorLayout coordinatorLayout0, View view0) {
    }

    public int E(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2) {
        int v3 = this.w();
        if(v1 != 0 && v3 >= v1 && v3 <= v2) {
            int v4 = E9.h.r(v, v1, v2);
            if(v3 != v4) {
                this.z(v4);
                return v3 - v4;
            }
        }
        return 0;
    }

    public final void F(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        this.E(coordinatorLayout0, view0, v, 0x80000000, 0x7FFFFFFF);
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean k(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        if(this.h < 0) {
            this.h = ViewConfiguration.get(coordinatorLayout0.getContext()).getScaledTouchSlop();
        }
        if(motionEvent0.getActionMasked() != 2 || !this.e) {
        label_11:
            if(motionEvent0.getActionMasked() == 0) {
                this.f = -1;
                int v3 = (int)motionEvent0.getX();
                int v4 = (int)motionEvent0.getY();
                boolean z = this.A(view0) && coordinatorLayout0.n(view0, v3, v4);
                this.e = z;
                if(z) {
                    this.g = v4;
                    this.f = motionEvent0.getPointerId(0);
                    if(this.i == null) {
                        this.i = VelocityTracker.obtain();
                    }
                    if(this.d != null && !this.d.isFinished()) {
                        this.d.abortAnimation();
                        return true;
                    }
                }
            }
            VelocityTracker velocityTracker0 = this.i;
            if(velocityTracker0 != null) {
                velocityTracker0.addMovement(motionEvent0);
            }
        }
        else {
            int v = this.f;
            if(v != -1) {
                int v1 = motionEvent0.findPointerIndex(v);
                if(v1 != -1) {
                    int v2 = (int)motionEvent0.getY(v1);
                    if(Math.abs(v2 - this.g) > this.h) {
                        this.g = v2;
                        return true;
                    }
                    goto label_11;
                }
            }
        }
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean v(CoordinatorLayout coordinatorLayout0, View view0, MotionEvent motionEvent0) {
        boolean z;
        switch(motionEvent0.getActionMasked()) {
            case 1: {
                VelocityTracker velocityTracker0 = this.i;
                if(velocityTracker0 == null) {
                    z = false;
                }
                else {
                    velocityTracker0.addMovement(motionEvent0);
                    this.i.computeCurrentVelocity(1000);
                    float f = this.i.getYVelocity(this.f);
                    int v = this.C(view0);
                    h h0 = this.c;
                    if(h0 != null) {
                        view0.removeCallbacks(h0);
                        this.c = null;
                    }
                    if(this.d == null) {
                        this.d = new OverScroller(view0.getContext());
                    }
                    this.d.fling(0, this.w(), 0, Math.round(f), 0, 0, -v, 0);
                    if(this.d.computeScrollOffset()) {
                        h h1 = new h(this, coordinatorLayout0, view0);
                        this.c = h1;
                        view0.postOnAnimation(h1);
                    }
                    else {
                        this.D(coordinatorLayout0, view0);
                    }
                    z = true;
                }
                goto label_37;
            }
            case 2: {
                int v1 = motionEvent0.findPointerIndex(this.f);
                if(v1 != -1) {
                    int v2 = (int)motionEvent0.getY(v1);
                    int v3 = this.g - v2;
                    this.g = v2;
                    int v4 = this.B(view0);
                    this.E(coordinatorLayout0, view0, this.x() - v3, v4, 0);
                    z = false;
                    break;
                }
                return false;
            }
            case 3: {
                z = false;
            label_37:
                this.e = false;
                this.f = -1;
                VelocityTracker velocityTracker1 = this.i;
                if(velocityTracker1 != null) {
                    velocityTracker1.recycle();
                    this.i = null;
                }
                break;
            }
            case 6: {
                int v5 = motionEvent0.getActionIndex() == 0 ? 1 : 0;
                this.f = motionEvent0.getPointerId(v5);
                this.g = (int)(motionEvent0.getY(v5) + 0.5f);
                z = false;
                break;
            }
            default: {
                z = false;
            }
        }
        VelocityTracker velocityTracker2 = this.i;
        if(velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent0);
        }
        return this.e || z;
    }
}

