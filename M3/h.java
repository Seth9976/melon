package m3;

import I6.V;
import I6.Y;
import I6.w;
import androidx.media3.common.DrmInitData;
import i.n.i.b.a.s.e.Ta;
import java.util.List;
import java.util.Map;

public final class h extends l {
    public final int d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final DrmInitData q;
    public final V r;
    public final V s;
    public final Y t;
    public final long u;
    public final Ta v;

    public h(int v, String s, List list0, long v1, boolean z, long v2, boolean z1, int v3, long v4, int v5, long v6, long v7, boolean z2, boolean z3, boolean z4, DrmInitData drmInitData0, List list1, List list2, Ta ta0, Map map0) {
        super(s, list0, z2);
        this.d = v;
        this.h = v2;
        this.g = z;
        this.i = z1;
        this.j = v3;
        this.k = v4;
        this.l = v5;
        this.m = v6;
        this.n = v7;
        this.o = z3;
        this.p = z4;
        this.q = drmInitData0;
        this.r = V.p(list1);
        this.s = V.p(list2);
        this.t = Y.a(map0);
        if(!list2.isEmpty()) {
            d d0 = (d)w.j(list2);
            this.u = d0.e + d0.c;
        }
        else if(list1.isEmpty()) {
            this.u = 0L;
        }
        else {
            f f0 = (f)w.j(list1);
            this.u = f0.e + f0.c;
        }
        long v8 = 0x8000000000000001L;
        if(v1 != 0x8000000000000001L) {
            v8 = v1 < 0L ? Math.max(0L, this.u + v1) : Math.min(this.u, v1);
        }
        this.e = v8;
        this.f = v1 >= 0L;
        this.v = ta0;
    }

    @Override  // m3.l
    public final Object a(List list0) {
        return this;
    }
}

