package N0;

import A7.d;
import B2.o;
import I.L0;
import P0.I;
import P0.Q;
import P0.h;
import P0.i;
import P0.k;
import androidx.compose.runtime.J;
import androidx.compose.runtime.g;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import m0.b;
import r0.a;
import r0.q;
import we.n;
import x0.c;

public abstract class g0 {
    public static final j a;

    static {
        g0.a = new j(2);
    }

    public static final void a(q q0, b b0, M m0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1949933075);
        int v1 = (p0.g(q0) ? 4 : 2) | v | (p0.g(m0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            int v2 = p0.P;
            q q1 = a.d(p0, q0);
            i0 i00 = p0.m();
            i i0 = i.h;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            k.y.getClass();
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            if(p0.O) {
                g g0 = new g(2, 2);
                p0.c(H.a, g0);
            }
            w.x(p0, q1, P0.j.d);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                d.q(v2, p0, v2, h0);
            }
            b0.invoke(p0, 6);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new L0(q0, b0, m0, v, 1);
        }
    }

    public static final void b(j0 j00, q q0, n n0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xE17BA7B9);
        int v1 = (v & 6) == 0 ? (p0.i(j00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(n0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            int v2 = p0.P;
            androidx.compose.runtime.n n1 = w.v(p0);
            q q1 = a.d(p0, q0);
            i0 i00 = p0.m();
            i i0 = i.h;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, j00, j00.c);
            w.x(p0, n1, j00.d);
            w.x(p0, n0, j00.e);
            k.y.getClass();
            w.x(p0, i00, P0.j.e);
            w.x(p0, q1, P0.j.d);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                d.q(v2, p0, v2, h0);
            }
            p0.p(true);
            if(p0.D()) {
                p0.a0(0xFE6F30FB);
            }
            else {
                p0.a0(0xFE6E4BFE);
                boolean z = p0.i(j00);
                o o0 = p0.N();
                if(z || o0 == androidx.compose.runtime.k.a) {
                    o0 = new o(j00, 14);
                    p0.l0(o0);
                }
                J.h(o0, p0);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H.a(j00, q0, n0, v, 3);
        }
    }

    public static final void c(q q0, n n0, l l0, int v, int v1) {
        int v2;
        ((p)l0).c0(0xB29CB430);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (((p)l0).i(n0) ? 0x20 : 16);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 19) != 18)) {
            if((v1 & 1) != 0) {
                q0 = r0.n.a;
            }
            j0 j00 = ((p)l0).N();
            if(j00 == androidx.compose.runtime.k.a) {
                j00 = new j0(j.i);
                ((p)l0).l0(j00);
            }
            g0.b(j00, q0, n0, ((p)l0), v2 << 3 & 0x3F0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new f0(q0, n0, v, v1);
        }
    }

    public static final float d(long v, long v1) {
        return Math.min(Float.intBitsToFloat(((int)(v1 >> 0x20))) / Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
    }

    public static final c e(v v0) {
        v v1 = v0.X();
        return v1 == null ? new c(0.0f, 0.0f, ((float)(((int)(v0.l() >> 0x20)))), ((float)(((int)(v0.l() & 0xFFFFFFFFL))))) : v1.f(v0, true);
    }

    public static final c f(v v0) {
        v v1 = g0.g(v0);
        float f = (float)(((int)(v1.l() >> 0x20)));
        float f1 = (float)(((int)(v1.l() & 0xFFFFFFFFL)));
        c c0 = v1.f(v0, true);
        float f2 = c0.a;
        float f3 = 0.0f;
        if(f2 < 0.0f) {
            f2 = 0.0f;
        }
        if(f2 > f) {
            f2 = f;
        }
        float f4 = c0.b < 0.0f ? 0.0f : c0.b;
        if(f4 > f1) {
            f4 = f1;
        }
        float f5 = c0.c < 0.0f ? 0.0f : c0.c;
        if(f5 <= f) {
            f = f5;
        }
        float f6 = c0.d;
        if(f6 >= 0.0f) {
            f3 = f6;
        }
        if(f3 <= f1) {
            f1 = f3;
        }
        if(f2 == f || f4 == f1) {
            return c.e;
        }
        long v2 = v1.D(((long)Float.floatToRawIntBits(f2)) << 0x20 | ((long)Float.floatToRawIntBits(f4)) & 0xFFFFFFFFL);
        long v3 = v1.D(((long)Float.floatToRawIntBits(f4)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20);
        long v4 = v1.D(((long)Float.floatToRawIntBits(f)) << 0x20 | ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL);
        long v5 = v1.D(((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f2)) << 0x20);
        float f7 = Float.intBitsToFloat(((int)(v2 >> 0x20)));
        float f8 = Float.intBitsToFloat(((int)(v3 >> 0x20)));
        float f9 = Float.intBitsToFloat(((int)(v5 >> 0x20)));
        float f10 = Float.intBitsToFloat(((int)(v4 >> 0x20)));
        float f11 = Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL)));
        float f12 = Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL)));
        float f13 = Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL)));
        float f14 = Float.intBitsToFloat(((int)(v4 & 0xFFFFFFFFL)));
        return new c(Math.min(f7, Math.min(f8, Math.min(f9, f10))), Math.min(f11, Math.min(f12, Math.min(f13, f14))), Math.max(f7, Math.max(f8, Math.max(f9, f10))), Math.max(f11, Math.max(f12, Math.max(f13, f14))));
    }

    public static final v g(v v0) {
        v v3;
        v v2;
        for(v v1 = v0.X(); true; v1 = v0.X()) {
            v2 = v0;
            v0 = v1;
            if(v0 == null) {
                break;
            }
        }
        P0.j0 j00 = v2 instanceof P0.j0 ? ((P0.j0)v2) : null;
        if(j00 == null) {
            return v2;
        }
        for(P0.j0 j01 = j00.n; true; j01 = j00.n) {
            v3 = j00;
            j00 = j01;
            if(j00 == null) {
                break;
            }
        }
        return v3;
    }

    public static final Q h(Q q0) {
        I i0 = q0.l.l;
        while(true) {
            I i1 = i0.u();
            I i2 = null;
            if((i1 == null ? null : i1.h) == null) {
                break;
            }
            I i3 = i0.u();
            if(i3 != null) {
                i2 = i3.h;
            }
            kotlin.jvm.internal.q.d(i2);
            I i4 = i0.u();
            kotlin.jvm.internal.q.d(i4);
            i0 = i4.h;
            kotlin.jvm.internal.q.d(i0);
        }
        Q q1 = ((P0.j0)i0.b0.d).P0();
        kotlin.jvm.internal.q.d(q1);
        return q1;
    }

    public static final long i(long v, long v1) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) * Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 >> 0x20))) * Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20;
    }
}

