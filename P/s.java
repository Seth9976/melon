package P;

import E9.h;
import I.u0;
import N0.N;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import je.p;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import r1.c;
import we.k;

public final class s implements N {
    public final u a;
    public final int b;
    public final boolean c;
    public final float d;
    public final N e;
    public final float f;
    public final boolean g;
    public final CoroutineScope h;
    public final c i;
    public final int j;
    public final r k;
    public final Object l;
    public final int m;
    public final int n;
    public final int o;
    public final u0 p;
    public final int q;
    public final int r;

    public s(u u0, int v, boolean z, float f, N n0, float f1, boolean z1, CoroutineScope coroutineScope0, c c0, int v1, k k0, List list0, int v2, int v3, int v4, u0 u00, int v5, int v6) {
        this.a = u0;
        this.b = v;
        this.c = z;
        this.d = f;
        this.e = n0;
        this.f = f1;
        this.g = z1;
        this.h = coroutineScope0;
        this.i = c0;
        this.j = v1;
        this.k = (r)k0;
        this.l = list0;
        this.m = v2;
        this.n = v3;
        this.o = v4;
        this.p = u00;
        this.q = v5;
        this.r = v6;
    }

    @Override  // N0.N
    public final Map a() {
        return this.e.a();
    }

    @Override  // N0.N
    public final void b() {
        this.e.b();
    }

    @Override  // N0.N
    public final k c() {
        return this.e.c();
    }

    public final s d(int v, boolean z) {
        int v7;
        int v6;
        if(!this.g) {
            Object object0 = this.l;
            if(!((List)object0).isEmpty()) {
                u u0 = this.a;
                if(u0 != null) {
                    int v1 = this.b - v;
                    if(v1 >= 0 && v1 < u0.h) {
                        t t0 = (t)p.k0(((List)object0));
                        t t1 = (t)p.s0(((List)object0));
                        if(!t0.s && !t1.s) {
                            int v2 = this.n;
                            int v3 = this.m;
                            u0 u00 = this.p;
                            if(v < 0) {
                                int v4 = h.T(t0, u00);
                                int v5 = h.T(t1, u00);
                                if(Math.min(v4 + t0.m - v3, v5 + t1.m - v2) > -v) {
                                    v6 = ((Collection)object0).size();
                                    v7 = 0;
                                    goto label_23;
                                }
                            }
                            else if(Math.min(v3 - h.T(t0, u00), v2 - h.T(t1, u00)) > v) {
                                v6 = ((Collection)object0).size();
                                v7 = 0;
                            label_23:
                                while(v7 < v6) {
                                    t t2 = (t)((List)object0).get(v7);
                                    boolean z1 = t2.c;
                                    if(!t2.s) {
                                        t2.p = ((long)(z1 ? ((int)(t2.p >> 0x20)) : ((int)(t2.p >> 0x20)) + v)) << 0x20 | ((long)(z1 ? ((int)(t2.p & 0xFFFFFFFFL)) + v : ((int)(t2.p & 0xFFFFFFFFL)))) & 0xFFFFFFFFL;
                                        if(z) {
                                            int v8 = t2.f.size();
                                            for(int v9 = 0; v9 < v8; ++v9) {
                                                t2.i.a(v9, t2.b);
                                            }
                                        }
                                    }
                                    ++v7;
                                }
                                return this.c || v > 0 ? new s(this.a, v1, true, ((float)v), this.e, this.f, this.g, this.h, this.i, this.j, ((k)this.k), ((List)object0), this.m, this.n, this.o, u00, this.q, this.r) : new s(this.a, v1, false, ((float)v), this.e, this.f, this.g, this.h, this.i, this.j, ((k)this.k), ((List)object0), this.m, this.n, this.o, u00, this.q, this.r);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final long e() {
        return ((long)this.e.getWidth()) << 0x20 | ((long)this.e.getHeight()) & 0xFFFFFFFFL;
    }

    @Override  // N0.N
    public final int getHeight() {
        return this.e.getHeight();
    }

    @Override  // N0.N
    public final int getWidth() {
        return this.e.getWidth();
    }
}

