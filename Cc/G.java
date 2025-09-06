package Cc;

import P0.h;
import P0.i;
import P0.j;
import T.d;
import T.e;
import androidx.compose.foundation.lazy.a;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import d5.n;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import r0.q;
import we.k;
import we.p;
import y0.M;

public final class g extends r implements p {
    public final float B;
    public final List f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final float n;
    public final k o;
    public final float r;
    public final float w;

    public g(List list0, int v, int v1, int v2, int v3, int v4, int v5, int v6, float f, k k0, float f1, float f2, float f3) {
        this.f = list0;
        this.g = v;
        this.h = v1;
        this.i = v2;
        this.j = v3;
        this.k = v4;
        this.l = v5;
        this.m = v6;
        this.n = f;
        this.o = k0;
        this.r = f1;
        this.w = f2;
        this.B = f3;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object2));
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            b b0 = (b)this.f.get(v);
            p0.a0(0x6A9919AD);
            boolean z = this.g == v;
            int v3 = z ? this.l : this.m;
            d d0 = e.b(this.n);
            q q0 = n.o(r0.n.a, d0);
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, (z ? this.h : this.i)), 0.5f);
            d d1 = e.b(this.n - 0.5f);
            q q1 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d1), e0.T(p0, (z ? this.j : this.k)), M.a);
            k k0 = this.o;
            boolean z1 = p0.g(k0);
            boolean z2 = (v2 & 0x70 ^ 0x30) > 0x20 && p0.e(v) || (v2 & 0x30) == 0x20;
            Cc.e e0 = p0.N();
            if(z2 || z1 || e0 == androidx.compose.runtime.k.a) {
                e0 = new Cc.e(k0, v, 0);
                p0.l0(e0);
            }
            q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.n(q1, null, e0, 7), this.r, 0.0f, 2), this.w);
            N0.M m0 = M.p.d(r0.d.e, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q3, j.d);
            long v5 = e0.T(p0, v3);
            N1.b(b0.a, null, v5, this.B, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFF2);
            p0.p(true);
            p0.p(false);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

