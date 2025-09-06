package Af;

import Pe.L;
import e.k;
import je.w;
import tf.m;
import we.a;

public final class s implements a {
    public final int a;
    public final t b;

    public s(t t0, int v) {
        this.a = v;
        this.b = t0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            t t0 = this.b;
            return t0.c ? k.B(m.h(t0.b)) : w.a;
        }
        return k.A(new L[]{m.i(this.b.b), m.j(this.b.b)});
    }
}

