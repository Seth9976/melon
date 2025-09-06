package com.google.android.material.appbar;

import android.view.View;

public final class i {
    public final View a;
    public int b;
    public int c;
    public int d;

    public i(View view0) {
        this.a = view0;
    }

    public final void a() {
        int v = this.d;
        int v1 = this.a.getTop();
        this.a.offsetTopAndBottom(v - (v1 - this.b));
        int v2 = this.a.getLeft();
        this.a.offsetLeftAndRight(-(v2 - this.c));
    }

    public final boolean b(int v) {
        if(this.d != v) {
            this.d = v;
            this.a();
            return true;
        }
        return false;
    }
}

