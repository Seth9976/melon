package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;

public final class b {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public int l;
    public int m;
    public final ArrayList n;
    public int o;
    public int p;

    public b() {
        this.a = 0x7FFFFFFF;
        this.b = 0x7FFFFFFF;
        this.c = 0x80000000;
        this.d = 0x80000000;
        this.n = new ArrayList();
    }

    public final int a() {
        return this.h - this.i;
    }

    public final void b(View view0, int v, int v1, int v2, int v3) {
        FlexItem flexItem0 = (FlexItem)view0.getLayoutParams();
        this.a = Math.min(this.a, view0.getLeft() - flexItem0.P() - v);
        this.b = Math.min(this.b, view0.getTop() - flexItem0.r() - v1);
        this.c = Math.max(this.c, view0.getRight() + flexItem0.b0() + v2);
        this.d = Math.max(this.d, view0.getBottom() + flexItem0.N() + v3);
    }
}

