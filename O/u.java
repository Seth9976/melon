package O;

import I.u0;
import N0.N;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import je.p;
import kotlinx.coroutines.CoroutineScope;
import r1.c;
import we.k;

public final class u implements N {
    public final v a;
    public final int b;
    public final boolean c;
    public final float d;
    public final N e;
    public final float f;
    public final boolean g;
    public final CoroutineScope h;
    public final c i;
    public final long j;
    public final Object k;
    public final int l;
    public final int m;
    public final int n;
    public final boolean o;
    public final u0 p;
    public final int q;
    public final int r;

    public u(v v0, int v1, boolean z, float f, N n0, float f1, boolean z1, CoroutineScope coroutineScope0, c c0, long v2, List list0, int v3, int v4, int v5, boolean z2, u0 u00, int v6, int v7) {
        this.a = v0;
        this.b = v1;
        this.c = z;
        this.d = f;
        this.e = n0;
        this.f = f1;
        this.g = z1;
        this.h = coroutineScope0;
        this.i = c0;
        this.j = v2;
        this.k = list0;
        this.l = v3;
        this.m = v4;
        this.n = v5;
        this.o = z2;
        this.p = u00;
        this.q = v6;
        this.r = v7;
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

    public final u d(int v, boolean z) {
        int v8;
        int v7;
        if(!this.g) {
            Object object0 = this.k;
            if(!((List)object0).isEmpty()) {
                v v1 = this.a;
                if(v1 != null) {
                    int v2 = this.b - v;
                    if(v2 >= 0 && v2 < v1.o) {
                        v v3 = (v)p.k0(((List)object0));
                        v v4 = (v)p.s0(((List)object0));
                        if(!v3.q && !v4.q) {
                            int v5 = this.m;
                            int v6 = this.l;
                            if(v >= 0) {
                                if(Math.min(v6 - v3.m, v5 - v4.m) > v) {
                                    v7 = ((Collection)object0).size();
                                    v8 = 0;
                                label_20:
                                    while(v8 < v7) {
                                        v v9 = (v)((List)object0).get(v8);
                                        boolean z1 = v9.c;
                                        int[] arr_v = v9.s;
                                        if(!v9.q) {
                                            v9.m += v;
                                            int v10 = arr_v.length;
                                            for(int v11 = 0; v11 < v10; ++v11) {
                                                if(z1 && (v11 & 1) != 0 || !z1 && (v11 & 1) == 0) {
                                                    arr_v[v11] += v;
                                                }
                                            }
                                            if(z) {
                                                int v12 = v9.b.size();
                                                for(int v13 = 0; v13 < v12; ++v13) {
                                                    v9.l.a(v13, v9.j);
                                                }
                                            }
                                        }
                                        ++v8;
                                    }
                                    return this.c || v > 0 ? new u(this.a, v2, true, ((float)v), this.e, this.f, this.g, this.h, this.i, this.j, ((List)object0), this.l, this.m, this.n, this.o, this.p, this.q, this.r) : new u(this.a, v2, false, ((float)v), this.e, this.f, this.g, this.h, this.i, this.j, ((List)object0), this.l, this.m, this.n, this.o, this.p, this.q, this.r);
                                }
                            }
                            else if(Math.min(v3.m + v3.o - v6, v4.m + v4.o - v5) > -v) {
                                v7 = ((Collection)object0).size();
                                v8 = 0;
                                goto label_20;
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

