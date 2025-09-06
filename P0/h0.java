package P0;

import ie.H;
import kotlin.jvm.internal.r;
import r0.p;
import we.a;

public final class h0 extends r implements a {
    public final j0 f;
    public final p g;
    public final d h;
    public final long i;
    public final t j;
    public final int k;
    public final boolean l;
    public final float m;
    public final boolean n;

    public h0(j0 j00, p p0, d d0, long v, t t0, int v1, boolean z, float f, boolean z1) {
        this.f = j00;
        this.g = p0;
        this.h = d0;
        this.i = v;
        this.j = t0;
        this.k = v1;
        this.l = z;
        this.m = f;
        this.n = z1;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        int v = this.h.c();
        p p0 = f.e(this.g, v);
        this.f.f1(p0, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
        return H.a;
    }
}

