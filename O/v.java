package O;

import L.a;
import N0.Z;
import N0.a0;
import androidx.compose.foundation.lazy.layout.A;
import androidx.compose.foundation.lazy.layout.s;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import r0.g;
import r0.h;
import r1.j;
import r1.m;

public final class v implements A {
    public final int a;
    public final List b;
    public final boolean c;
    public final g d;
    public final h e;
    public final m f;
    public final boolean g;
    public final int h;
    public final long i;
    public final Object j;
    public final Object k;
    public final s l;
    public int m;
    public final int n;
    public final int o;
    public final int p;
    public boolean q;
    public int r;
    public final int[] s;

    public v(int v, List list0, boolean z, g g0, h h0, m m0, boolean z1, int v1, int v2, int v3, long v4, Object object0, Object object1, s s0, long v5) {
        this.a = v;
        this.b = list0;
        this.c = z;
        this.d = g0;
        this.e = h0;
        this.f = m0;
        this.g = z1;
        this.h = v3;
        this.i = v4;
        this.j = object0;
        this.k = object1;
        this.l = s0;
        this.r = 0x80000000;
        int v6 = list0.size();
        int v7 = 0;
        int v9 = 0;
        int v10 = 0;
        for(int v8 = 0; v8 < v6; ++v8) {
            a0 a00 = (a0)list0.get(v8);
            v9 += (this.c ? a00.b : a00.a);
            v10 = Math.max(v10, (this.c ? a00.a : a00.b));
        }
        this.n = v9;
        int v11 = v9 + this.h;
        if(v11 >= 0) {
            v7 = v11;
        }
        this.o = v7;
        this.p = v10;
        this.s = new int[this.b.size() * 2];
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int a() {
        return this.b.size();
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int b() {
        return 1;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final boolean c() {
        return this.c;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int d() {
        return this.o;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final Object e(int v) {
        return ((a0)this.b.get(v)).q();
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final void f() {
        this.q = true;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final void g(int v, int v1, int v2) {
        this.k(v, v1, v2);
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int getIndex() {
        return this.a;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final Object getKey() {
        return this.j;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final long h(int v) {
        return ((long)this.s[v * 2]) << 0x20 | ((long)this.s[v * 2 + 1]) & 0xFFFFFFFFL;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int i() {
        return 0;
    }

    public final void j(Z z0) {
        long v4;
        long v3;
        if(this.r == 0x80000000) {
            a.a("position() should be called first");
        }
        List list0 = this.b;
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            a0 a00 = (a0)list0.get(v1);
            boolean z1 = this.c;
            long v2 = this.h(v1);
            this.l.a(v1, this.j);
            if(this.g) {
                if(z1) {
                    v3 = ((long)(((int)(v2 >> 0x20)))) << 0x20;
                    v4 = (long)(this.r - ((int)(v2 & 0xFFFFFFFFL)) - a00.b);
                }
                else {
                    v3 = ((long)(this.r - ((int)(v2 >> 0x20)) - a00.a)) << 0x20;
                    v4 = (long)(((int)(v2 & 0xFFFFFFFFL)));
                }
                v2 = v4 & 0xFFFFFFFFL | v3;
            }
            long v5 = j.c(v2, this.i);
            if(z1) {
                Z.l(z0, a00, v5);
            }
            else {
                Z.i(z0, a00, v5);
            }
        }
    }

    public final void k(int v, int v1, int v2) {
        int v5;
        this.m = v;
        boolean z = this.c;
        this.r = z ? v2 : v1;
        List list0 = this.b;
        int v3 = list0.size();
        int v4 = 0;
        while(v4 < v3) {
            a0 a00 = (a0)list0.get(v4);
            int[] arr_v = this.s;
            if(z) {
                g g0 = this.d;
                if(g0 != null) {
                    arr_v[v4 * 2] = g0.a(a00.a, v1, this.f);
                    arr_v[v4 * 2 + 1] = v;
                    v5 = a00.b;
                    v += v5;
                    ++v4;
                    continue;
                }
                a.b("null horizontalAlignment when isVertical == true");
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            else {
                arr_v[v4 * 2] = v;
                h h0 = this.e;
                if(h0 == null) {
                    a.b("null verticalAlignment when isVertical == false");
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                arr_v[v4 * 2 + 1] = h0.a(a00.b, v2);
                v5 = a00.a;
            }
            v += v5;
            ++v4;
        }
    }
}

