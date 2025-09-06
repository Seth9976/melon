package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior extends Behavior {
    public i a;
    public int b;

    public ViewOffsetBehavior() {
        this.b = 0;
    }

    public ViewOffsetBehavior(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = 0;
    }

    @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public boolean l(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        this.y(coordinatorLayout0, view0, v);
        if(this.a == null) {
            this.a = new i(view0);
        }
        i i0 = this.a;
        i0.b = i0.a.getTop();
        i0.c = i0.a.getLeft();
        this.a.a();
        int v1 = this.b;
        if(v1 != 0) {
            this.a.b(v1);
            this.b = 0;
        }
        return true;
    }

    public int w() {
        return this.a == null ? 0 : this.a.d;
    }

    public int x() {
        return this.w();
    }

    public void y(CoordinatorLayout coordinatorLayout0, View view0, int v) {
        coordinatorLayout0.p(view0, v);
    }

    public boolean z(int v) {
        i i0 = this.a;
        if(i0 != null) {
            return i0.b(v);
        }
        this.b = v;
        return false;
    }
}

