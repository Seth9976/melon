package kd;

import A0.d;
import A0.f;
import P0.K;
import jd.m3;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import we.k;
import y0.e;

public final class b implements k {
    public final boolean a;
    public final long b;
    public final d c;
    public final long d;
    public final H e;
    public final long f;
    public final int g;
    public final int h;
    public final H i;
    public final long j;
    public final m3 k;
    public final long l;
    public final long m;

    public b(boolean z, long v, d d0, long v1, H h0, long v2, int v3, int v4, H h1, long v5, m3 m30, long v6, long v7) {
        this.a = z;
        this.b = v;
        this.c = d0;
        this.d = v1;
        this.e = h0;
        this.f = v2;
        this.g = v3;
        this.h = v4;
        this.i = h1;
        this.j = v5;
        this.k = m30;
        this.l = v6;
        this.m = v7;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((f)object0), "$this$record");
        if(this.a) {
            f.d0(((f)object0), this.b, 0L, 0.0f, null, 0, 0x7E);
            ((K)this.c).a();
        }
        else {
            f.d0(((f)object0), this.d, 0L, 0.0f, null, 0, 0x7E);
            e e0 = (e)this.e.a;
            y0.k k0 = new y0.k(this.f, 5);
            long v = ((long)this.h) & 0xFFFFFFFFL | ((long)this.g) << 0x20;
            f.v(((f)object0), e0, 0L, v, 0.0f, k0, 0, 878);
            f.v(((f)object0), ((e)this.i.a), 0L, v, 0.0f, new y0.k(this.j, 5), 0, 878);
        }
        if(this.k != m3.a) {
            long v1 = ((f)object0).c();
            f.d0(((f)object0), this.l, v1, 0.0f, null, 0, 0x7A);
        }
        f.d0(((f)object0), this.m, 0L, 0.0f, null, 0, 0x7E);
        return ie.H.a;
    }
}

