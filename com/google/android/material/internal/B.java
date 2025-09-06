package com.google.android.material.internal;

import android.graphics.Typeface;

public final class b {
    public final int a;
    public final c b;

    public b(c c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    public final void a(Typeface typeface0) {
        if(this.a != 0) {
            c c0 = this.b;
            if(c0.o(typeface0)) {
                c0.i(false);
            }
            return;
        }
        c c1 = this.b;
        if(c1.m(typeface0)) {
            c1.i(false);
        }
    }
}

