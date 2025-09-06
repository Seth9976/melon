package com.google.android.material.behavior;

import A6.h;
import H0.b;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e1.n;
import e6.a;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HideBottomViewOnScrollBehavior extends Behavior {
    public final LinkedHashSet a;
    public int b;
    public int c;
    public TimeInterpolator d;
    public TimeInterpolator e;
    public int f;
    public int g;
    public int h;
    public ViewPropertyAnimator i;

    public HideBottomViewOnScrollBehavior() {
        this.a = new LinkedHashSet();
        this.f = 0;
        this.g = 2;
        this.h = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new LinkedHashSet();
        this.f = 0;
        this.g = 2;
        this.h = 0;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        this.f = view0.getMeasuredHeight() + viewGroup$MarginLayoutParams0.bottomMargin;
        this.b = n.B(view0.getContext(), 0x7F040454, 0xE1);  // attr:motionDurationLong2
        this.c = n.B(view0.getContext(), 0x7F04045A, 0xAF);  // attr:motionDurationMedium4
        this.d = n.C(view0.getContext(), 0x7F040464, a.d);  // attr:motionEasingEmphasizedInterpolator
        this.e = n.C(view0.getContext(), 0x7F040464, a.c);  // attr:motionEasingEmphasizedInterpolator
        return false;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public final void p(CoordinatorLayout coordinatorLayout0, View view0, int v, int v1, int v2, int[] arr_v) {
        LinkedHashSet linkedHashSet0 = this.a;
        if(v > 0) {
            if(this.g != 1) {
                ViewPropertyAnimator viewPropertyAnimator0 = this.i;
                if(viewPropertyAnimator0 != null) {
                    viewPropertyAnimator0.cancel();
                    view0.clearAnimation();
                }
                this.g = 1;
                Iterator iterator0 = linkedHashSet0.iterator();
                if(iterator0.hasNext()) {
                    throw b.b(iterator0);
                }
                int v3 = this.f + this.h;
                long v4 = (long)this.c;
                TimeInterpolator timeInterpolator0 = this.e;
                this.i = view0.animate().translationY(((float)v3)).setInterpolator(timeInterpolator0).setDuration(v4).setListener(new h(this, 8));
            }
        }
        else if(v < 0 && this.g != 2) {
            ViewPropertyAnimator viewPropertyAnimator1 = this.i;
            if(viewPropertyAnimator1 != null) {
                viewPropertyAnimator1.cancel();
                view0.clearAnimation();
            }
            this.g = 2;
            Iterator iterator1 = linkedHashSet0.iterator();
            if(iterator1.hasNext()) {
                throw b.b(iterator1);
            }
            long v5 = (long)this.b;
            TimeInterpolator timeInterpolator1 = this.d;
            this.i = view0.animate().translationY(0.0f).setInterpolator(timeInterpolator1).setDuration(v5).setListener(new h(this, 8));
        }
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean t(CoordinatorLayout coordinatorLayout0, View view0, View view1, View view2, int v, int v1) {
        return v == 2;
    }
}

