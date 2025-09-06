package de;

import C9.e;
import R6.d;
import S2.c;
import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import ea.a;

public final class g implements o0 {
    public final e a;
    public final o0 b;
    public final de.e c;
    public static final d d;

    static {
        g.d = new d(28);
    }

    public g(e e0, o0 o00, a a0) {
        this.a = e0;
        this.b = o00;
        this.c = new de.e(a0, 0);
    }

    @Override  // androidx.lifecycle.o0
    public final m0 create(Class class0) {
        if(!this.a.containsKey(class0)) {
            return this.b.create(class0);
        }
        this.c.create(class0);
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.lifecycle.o0
    public final m0 create(Class class0, c c0) {
        return this.a.containsKey(class0) ? this.c.create(class0, c0) : this.b.create(class0, c0);
    }
}

