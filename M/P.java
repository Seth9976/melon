package M;

import N0.L;
import N0.M;
import N0.Z;
import N0.a0;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import androidx.collection.K;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import r0.a;
import r0.d;
import r0.e;
import r0.q;

public abstract class p {
    public static final K a;
    public static final K b;
    public static final o c;

    static {
        p.a = p.c(true);
        p.b = p.c(false);
        new s(d.a, false);
        p.c = o.b;
    }

    public static final void a(q q0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(-211209833);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(q0) ? 4 : 2) | v : v;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            int v2 = ((androidx.compose.runtime.p)l0).P;
            q q1 = a.d(((androidx.compose.runtime.p)l0), q0);
            i0 i00 = ((androidx.compose.runtime.p)l0).m();
            k.y.getClass();
            i i0 = j.b;
            ((androidx.compose.runtime.p)l0).e0();
            if(((androidx.compose.runtime.p)l0).O) {
                ((androidx.compose.runtime.p)l0).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)l0).o0();
            }
            w.x(((androidx.compose.runtime.p)l0), p.c, j.f);
            w.x(((androidx.compose.runtime.p)l0), i00, j.e);
            w.x(((androidx.compose.runtime.p)l0), q1, j.d);
            h h0 = j.g;
            if(((androidx.compose.runtime.p)l0).O || !kotlin.jvm.internal.q.b(((androidx.compose.runtime.p)l0).N(), v2)) {
                A7.d.q(v2, ((androidx.compose.runtime.p)l0), v2, h0);
            }
            ((androidx.compose.runtime.p)l0).p(true);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new m(q0, v, 0);
        }
    }

    public static final void b(Z z0, a0 a00, L l0, r1.m m0, int v, int v1, e e0) {
        e e2;
        Object object0 = l0.q();
        M.l l1 = object0 instanceof M.l ? ((M.l)object0) : null;
        if(l1 == null) {
            e2 = e0;
        }
        else {
            e e1 = l1.a;
            e2 = e1 == null ? e0 : e1;
        }
        Z.f(z0, a00, e2.a(((long)a00.a) << 0x20 | ((long)a00.b) & 0xFFFFFFFFL, ((long)v) << 0x20 | ((long)v1) & 0xFFFFFFFFL, m0));
    }

    public static final K c(boolean z) {
        K k0 = new K(9);
        s s0 = new s(d.a, z);
        k0.l(d.a, s0);
        s s1 = new s(d.b, z);
        k0.l(d.b, s1);
        s s2 = new s(d.c, z);
        k0.l(d.c, s2);
        s s3 = new s(d.d, z);
        k0.l(d.d, s3);
        s s4 = new s(d.e, z);
        k0.l(d.e, s4);
        s s5 = new s(d.f, z);
        k0.l(d.f, s5);
        s s6 = new s(d.g, z);
        k0.l(d.g, s6);
        s s7 = new s(d.h, z);
        k0.l(d.h, s7);
        s s8 = new s(d.i, z);
        k0.l(d.i, s8);
        return k0;
    }

    public static final M d(e e0, boolean z) {
        M m0 = (M)(z ? p.a : p.b).g(e0);
        return m0 == null ? new s(e0, z) : m0;
    }
}

