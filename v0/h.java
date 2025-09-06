package v0;

import A0.b;
import A0.d;
import C0.c;
import F.B;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import N0.g0;
import N0.k;
import N0.q;
import P0.K;
import P0.z;
import je.x;
import r0.e;
import r0.p;
import r1.a;
import y0.t;

public final class h extends p implements P0.p, z {
    public c a;
    public boolean b;
    public e c;
    public k d;
    public float e;
    public t f;

    @Override  // P0.p
    public final void draw(d d0) {
        long v = this.a.getIntrinsicSize-NH-jbRc();
        float f = h.o0(v) ? Float.intBitsToFloat(((int)(v >> 0x20))) : Float.intBitsToFloat(((int)(((K)d0).a.c() >> 0x20)));
        long v1 = ((long)Float.floatToRawIntBits((h.n0(v) ? Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) : Float.intBitsToFloat(((int)(((K)d0).a.c() & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
        b b0 = ((K)d0).a;
        long v2 = Float.intBitsToFloat(((int)(b0.c() >> 0x20))) != 0.0f && Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL))) != 0.0f ? g0.i(v1, this.d.a(v1, b0.c())) : 0L;
        long v3 = this.c.a(((long)Math.round(Float.intBitsToFloat(((int)(v2 >> 0x20))))) << 0x20 | ((long)Math.round(Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))))) & 0xFFFFFFFFL, ((long)Math.round(Float.intBitsToFloat(((int)(b0.c() >> 0x20))))) << 0x20 | ((long)Math.round(Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL))))) & 0xFFFFFFFFL, ((K)d0).getLayoutDirection());
        float f1 = (float)(((int)(v3 >> 0x20)));
        float f2 = (float)(((int)(v3 & 0xFFFFFFFFL)));
        ((A0.c)b0.b.a).M(f1, f2);
        try {
            this.a.draw-x_KDEd0(d0, v2, this.e, this.f);
        }
        finally {
            ((A0.c)b0.b.a).M(-f1, -f2);
        }
        ((K)d0).a();
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean m0() {
        return this.b && this.a.getIntrinsicSize-NH-jbRc() != 0x7FC000007FC00000L;
    }

    // 去混淆评级： 低(20)
    @Override  // P0.z
    public final int maxIntrinsicHeight(q q0, N0.p p0, int v) {
        return this.m0() ? Math.max(a.i(this.p0(r1.b.b(v, 0, 13))), p0.d(v)) : p0.d(v);
    }

    // 去混淆评级： 低(20)
    @Override  // P0.z
    public final int maxIntrinsicWidth(q q0, N0.p p0, int v) {
        return this.m0() ? Math.max(a.j(this.p0(r1.b.b(0, v, 7))), p0.N(v)) : p0.N(v);
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        a0 a00 = l0.O(this.p0(v));
        int v1 = a00.a;
        int v2 = a00.b;
        B b0 = new B(a00, 14);
        return o0.w(v1, v2, x.a, b0);
    }

    // 去混淆评级： 低(20)
    @Override  // P0.z
    public final int minIntrinsicHeight(q q0, N0.p p0, int v) {
        return this.m0() ? Math.max(a.i(this.p0(r1.b.b(v, 0, 13))), p0.C(v)) : p0.C(v);
    }

    // 去混淆评级： 低(20)
    @Override  // P0.z
    public final int minIntrinsicWidth(q q0, N0.p p0, int v) {
        return this.m0() ? Math.max(a.j(this.p0(r1.b.b(0, v, 7))), p0.L(v)) : p0.L(v);
    }

    public static boolean n0(long v) {
        return !x0.e.a(v, 0x7FC000007FC00000L) && (Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) & 0x7FFFFFFF) < 0x7F800000;
    }

    public static boolean o0(long v) {
        return !x0.e.a(v, 0x7FC000007FC00000L) && (Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20)))) & 0x7FFFFFFF) < 0x7F800000;
    }

    public final long p0(long v) {
        boolean z = false;
        boolean z1 = a.d(v) && a.c(v);
        if(a.f(v) && a.e(v)) {
            z = true;
        }
        if(!this.m0() && z1 || z) {
            return a.a(v, a.h(v), 0, a.g(v), 0, 10);
        }
        long v1 = this.a.getIntrinsicSize-NH-jbRc();
        long v2 = ((long)Float.floatToRawIntBits(r1.b.f((h.n0(v1) ? Math.round(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)))) : a.i(v)), v))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(r1.b.g((h.o0(v1) ? Math.round(Float.intBitsToFloat(((int)(v1 >> 0x20)))) : a.j(v)), v))) << 0x20;
        if(this.m0()) {
            long v3 = ((long)Float.floatToRawIntBits((h.o0(this.a.getIntrinsicSize-NH-jbRc()) ? Float.intBitsToFloat(((int)(this.a.getIntrinsicSize-NH-jbRc() >> 0x20))) : Float.intBitsToFloat(((int)(v2 >> 0x20)))))) << 0x20 | ((long)Float.floatToRawIntBits((h.n0(this.a.getIntrinsicSize-NH-jbRc()) ? Float.intBitsToFloat(((int)(this.a.getIntrinsicSize-NH-jbRc() & 0xFFFFFFFFL))) : Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)))))) & 0xFFFFFFFFL;
            if(Float.intBitsToFloat(((int)(v2 >> 0x20))) == 0.0f || Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))) == 0.0f) {
                return a.a(v, r1.b.g(0, v), 0, r1.b.f(0, v), 0, 10);
            }
            v2 = g0.i(v3, this.d.a(v3, v2));
        }
        return a.a(v, r1.b.g(Math.round(Float.intBitsToFloat(((int)(v2 >> 0x20)))), v), 0, r1.b.f(Math.round(Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)))), v), 0, 10);
    }

    @Override
    public final String toString() {
        return "PainterModifier(painter=" + this.a + ", sizeToIntrinsics=" + this.b + ", alignment=" + this.c + ", alpha=" + this.e + ", colorFilter=" + this.f + ')';
    }
}

