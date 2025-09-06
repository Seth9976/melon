package O;

import androidx.compose.foundation.lazy.layout.B;
import androidx.compose.foundation.lazy.layout.z;
import java.util.List;
import r0.g;
import r0.h;
import r1.a;
import r1.b;
import r1.m;

public final class p implements B {
    public final k a;
    public final z b;
    public final long c;
    public final boolean d;
    public final z e;
    public final int f;
    public final int g;
    public final g h;
    public final h i;
    public final boolean j;
    public final int k;
    public final int l;
    public final long m;
    public final F n;

    public p(long v, boolean z, k k0, z z1, int v1, int v2, g g0, h h0, boolean z2, int v3, int v4, long v5, F f0) {
        this.d = z;
        this.e = z1;
        this.f = v1;
        this.g = v2;
        this.h = g0;
        this.i = h0;
        this.j = z2;
        this.k = v3;
        this.l = v4;
        this.m = v5;
        this.n = f0;
        this.a = k0;
        this.b = z1;
        int v6 = 0x7FFFFFFF;
        int v7 = z ? a.h(v) : 0x7FFFFFFF;
        if(!z) {
            v6 = a.g(v);
        }
        this.c = b.b(v7, v6, 5);
    }

    public final v a(int v, long v1) {
        Object object0 = this.a.c(v);
        Object object1 = this.a.b.m(v);
        List list0 = this.b.a(v, v1);
        m m0 = this.e.b.getLayoutDirection();
        return new v(v, list0, this.d, this.h, this.i, m0, this.j, this.k, this.l, (v == this.f - 1 ? 0 : this.g), this.m, object0, object1, this.n.m, v1);
    }
}

