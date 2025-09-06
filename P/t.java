package P;

import L.a;
import N0.Z;
import N0.a0;
import androidx.compose.foundation.lazy.layout.A;
import androidx.compose.foundation.lazy.layout.s;
import java.util.List;
import r1.j;
import r1.m;

public final class t implements A {
    public final int a;
    public final Object b;
    public final boolean c;
    public final int d;
    public final m e;
    public final List f;
    public final long g;
    public final Object h;
    public final s i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public int n;
    public final long o;
    public long p;
    public int q;
    public int r;
    public boolean s;

    public t(int v, Object object0, boolean z, int v1, int v2, m m0, int v3, int v4, List list0, long v5, Object object1, s s0, long v6, int v7, int v8) {
        this.a = v;
        this.b = object0;
        this.c = z;
        this.d = v1;
        this.e = m0;
        this.f = list0;
        this.g = v5;
        this.h = object1;
        this.i = s0;
        this.j = v7;
        this.k = v8;
        this.n = 0x80000000;
        int v9 = list0.size();
        int v10 = 0;
        int v12 = 0;
        for(int v11 = 0; v11 < v9; ++v11) {
            a0 a00 = (a0)list0.get(v11);
            v12 = Math.max(v12, (this.c ? a00.b : a00.a));
        }
        this.l = v12;
        int v13 = v2 + v12;
        if(v13 >= 0) {
            v10 = v13;
        }
        this.m = v10;
        this.o = this.c ? ((long)v12) & 0xFFFFFFFFL | ((long)this.d) << 0x20 : ((long)this.d) & 0xFFFFFFFFL | ((long)v12) << 0x20;
        this.p = 0L;
        this.q = -1;
        this.r = -1;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int a() {
        return this.f.size();
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int b() {
        return this.k;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final boolean c() {
        return this.c;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int d() {
        return this.m;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final Object e(int v) {
        return ((a0)this.f.get(v)).q();
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final void f() {
        this.s = true;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final void g(int v, int v1, int v2) {
        this.k(v, 0, v1, v2, -1, -1);
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int getIndex() {
        return this.a;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final Object getKey() {
        return this.b;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final long h(int v) {
        return this.p;
    }

    @Override  // androidx.compose.foundation.lazy.layout.A
    public final int i() {
        return this.j;
    }

    public final void j(Z z0) {
        if(this.n == 0x80000000) {
            a.a("position() should be called first");
        }
        List list0 = this.f;
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            a0 a00 = (a0)list0.get(v1);
            long v2 = this.p;
            this.i.a(v1, this.b);
            long v3 = j.c(v2, this.g);
            if(this.c) {
                Z.l(z0, a00, v3);
            }
            else {
                Z.i(z0, a00, v3);
            }
        }
    }

    public final void k(int v, int v1, int v2, int v3, int v4, int v5) {
        long v7;
        long v6;
        boolean z = this.c;
        this.n = z ? v3 : v2;
        if(!z) {
            v2 = v3;
        }
        if(z && this.e == m.b) {
            v1 = v2 - v1 - this.d;
        }
        if(z) {
            v6 = ((long)v1) << 0x20;
            v7 = (long)v;
        }
        else {
            v6 = ((long)v) << 0x20;
            v7 = (long)v1;
        }
        this.p = v7 & 0xFFFFFFFFL | v6;
        this.q = v4;
        this.r = v5;
    }
}

