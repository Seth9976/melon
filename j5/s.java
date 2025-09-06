package j5;

import A0.d;
import C0.c;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import N0.g0;
import N0.k;
import N0.q;
import P0.K;
import P0.z;
import e1.m;
import e1.n;
import je.x;
import r0.e;
import r0.p;
import r1.b;
import y0.t;
import ye.a;

public final class s extends p implements P0.p, z {
    public c a;
    public e b;
    public k c;
    public float d;
    public t e;

    @Override  // P0.p
    public final void draw(d d0) {
        long v = this.m0(((K)d0).a.c());
        e e0 = this.b;
        long v1 = n.c(a.V(x0.e.d(v)), a.V(x0.e.b(v)));
        long v2 = ((K)d0).a.c();
        long v3 = e0.a(v1, n.c(a.V(x0.e.d(v2)), a.V(x0.e.b(v2))), ((K)d0).getLayoutDirection());
        float f = (float)(((int)(v3 >> 0x20)));
        float f1 = (float)(((int)(v3 & 0xFFFFFFFFL)));
        ((A0.c)((K)d0).a.b.a).M(f, f1);
        this.a.draw-x_KDEd0(d0, v, this.d, this.e);
        ((A0.c)((K)d0).a.b.a).M(-f, -f1);
        ((K)d0).a();
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final long m0(long v) {
        if(x0.e.e(v)) {
            return 0L;
        }
        long v1 = this.a.getIntrinsicSize-NH-jbRc();
        if(v1 != 0x7FC000007FC00000L) {
            float f = x0.e.d(v1);
            float f1 = x0.e.b(v1);
            long v2 = m.i((!Float.isInfinite(f) && !Float.isNaN(f) ? x0.e.d(v1) : x0.e.d(v)), (!Float.isInfinite(f1) && !Float.isNaN(f1) ? x0.e.b(v1) : x0.e.b(v)));
            long v3 = this.c.a(v2, v);
            float f2 = Float.intBitsToFloat(((int)(v3 >> 0x20)));
            if(!Float.isInfinite(f2) && !Float.isNaN(f2)) {
                float f3 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & v3)));
                return Float.isInfinite(f3) || Float.isNaN(f3) ? v : g0.i(v2, v3);
            }
        }
        return v;
    }

    @Override  // P0.z
    public final int maxIntrinsicHeight(q q0, N0.p p0, int v) {
        if(this.a.getIntrinsicSize-NH-jbRc() != 0x7FC000007FC00000L) {
            int v1 = p0.d(r1.a.h(this.n0(b.b(v, 0, 13))));
            return Math.max(a.V(x0.e.b(this.m0(m.i(v, v1)))), v1);
        }
        return p0.d(v);
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(q q0, N0.p p0, int v) {
        if(this.a.getIntrinsicSize-NH-jbRc() != 0x7FC000007FC00000L) {
            int v1 = p0.N(r1.a.g(this.n0(b.b(0, v, 7))));
            return Math.max(a.V(x0.e.d(this.m0(m.i(v1, v)))), v1);
        }
        return p0.N(v);
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        a0 a00 = l0.O(this.n0(v));
        int v1 = a00.a;
        int v2 = a00.b;
        j5.p p0 = new j5.p(a00, 1);
        return o0.w(v1, v2, x.a, p0);
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(q q0, N0.p p0, int v) {
        if(this.a.getIntrinsicSize-NH-jbRc() != 0x7FC000007FC00000L) {
            int v1 = p0.C(r1.a.h(this.n0(b.b(v, 0, 13))));
            return Math.max(a.V(x0.e.b(this.m0(m.i(v, v1)))), v1);
        }
        return p0.C(v);
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(q q0, N0.p p0, int v) {
        if(this.a.getIntrinsicSize-NH-jbRc() != 0x7FC000007FC00000L) {
            int v1 = p0.L(r1.a.g(this.n0(b.b(0, v, 7))));
            return Math.max(a.V(x0.e.d(this.m0(m.i(v1, v)))), v1);
        }
        return p0.L(v);
    }

    public final long n0(long v) {
        float f1;
        float f;
        boolean z = r1.a.f(v);
        boolean z1 = r1.a.e(v);
        if(z && z1) {
            return v;
        }
        boolean z2 = r1.a.d(v) && r1.a.c(v);
        long v1 = this.a.getIntrinsicSize-NH-jbRc();
        if(v1 == 0x7FC000007FC00000L) {
            return z2 ? r1.a.a(v, r1.a.h(v), 0, r1.a.g(v), 0, 10) : v;
        }
        if(!z2 || !z && !z1) {
            float f2 = x0.e.d(v1);
            float f3 = x0.e.b(v1);
            f = Float.isInfinite(f2) || Float.isNaN(f2) ? ((float)r1.a.j(v)) : P4.a.i(f2, r1.a.j(v), r1.a.h(v));
            f1 = Float.isInfinite(f3) || Float.isNaN(f3) ? ((float)r1.a.i(v)) : P4.a.i(f3, r1.a.i(v), r1.a.g(v));
        }
        else {
            f = (float)r1.a.h(v);
            f1 = (float)r1.a.g(v);
        }
        long v2 = this.m0(m.i(f, f1));
        return r1.a.a(v, b.g(a.V(x0.e.d(v2)), v), 0, b.f(a.V(x0.e.b(v2)), v), 0, 10);
    }
}

