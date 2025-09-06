package androidx.lifecycle;

import De.d;
import P4.a;
import S2.c;
import kotlin.jvm.internal.q;

public class p0 implements o0 {
    public static p0 a;

    @Override  // androidx.lifecycle.o0
    public final m0 create(d d0, c c0) {
        q.g(d0, "modelClass");
        return this.create(df.d.v(d0), c0);
    }

    @Override  // androidx.lifecycle.o0
    public m0 create(Class class0) {
        q.g(class0, "modelClass");
        return a.n(class0);
    }

    @Override  // androidx.lifecycle.o0
    public m0 create(Class class0, c c0) {
        q.g(c0, "extras");
        return this.create(class0);
    }
}

