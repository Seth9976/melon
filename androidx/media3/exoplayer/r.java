package androidx.media3.exoplayer;

import b3.O;
import b3.P;
import b3.m;
import e3.j;
import e3.k;

public final class r implements j, k {
    public final int a;
    public final B b;

    public r(B b0, int v) {
        this.a = v;
        this.b = b0;
        super();
    }

    @Override  // e3.k
    public void a(Object object0, m m0) {
        O o0 = new O(m0);
        ((P)object0).M(this.b.g, o0);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).n0(this.b.M);
            return;
        }
        ((P)object0).u0(this.b.O);
    }
}

