package androidx.compose.animation;

import Cc.H1;
import F.H;
import F.r;
import F.y;
import G.l0;
import G.m0;
import G.t0;
import G.w0;
import G.z0;
import P0.h;
import P0.j;
import Q0.k0;
import androidx.collection.K;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import java.util.ListIterator;
import je.n;
import kd.G;
import m0.b;
import m0.c;
import p0.p;
import r0.d;
import r0.e;
import r0.i;
import r0.q;
import r1.m;
import we.k;

public abstract class a {
    public static final long a;
    public static final int b;

    static {
        a.a = 0x8000000080000000L;
    }

    public static final void a(t0 t00, q q0, k k0, k k1, l l0, int v) {
        l0 l00;
        V v6;
        K k3;
        p p2;
        i i0 = d.a;
        b b0 = G.c;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xF929FA7C);
        int v1 = (v & 6) == 0 ? (p0.g(t00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.g(i0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.i(k1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(b0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            m m0 = (m)p0.k(k0.n);
            r r0 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if((v1 & 14) == 4 || r0 == v2) {
                r0 = new r(t00);
                p0.l0(r0);
            }
            p p1 = p0.N();
            if((v1 & 14) == 4 || p1 == v2) {
                Object[] arr_object = {t00.c()};
                p1 = new p();
                p1.addAll(n.z0(arr_object));
                p0.l0(p1);
            }
            K k2 = p0.N();
            if((v1 & 14) == 4 || k2 == v2) {
                k2 = new K();
                p0.l0(k2);
            }
            Object object0 = t00.c();
            b0 b00 = t00.d;
            if(!p1.contains(object0)) {
                p1.clear();
                p1.add(t00.c());
            }
            if(kotlin.jvm.internal.q.b(t00.c(), ((O0)b00).getValue())) {
                if(p1.size() != 1 || !kotlin.jvm.internal.q.b(p1.get(0), t00.c())) {
                    p1.clear();
                    p1.add(t00.c());
                }
                if(k2.e != 1 || k2.c(t00.c())) {
                    k2.a();
                }
                r0.getClass();
            }
            if(!kotlin.jvm.internal.q.b(t00.c(), ((O0)b00).getValue()) && !p1.contains(((O0)b00).getValue())) {
                ListIterator listIterator0 = p1.listIterator();
                int v3;
                for(v3 = 0; true; ++v3) {
                    if(!((P0.r)listIterator0).hasNext()) {
                        v3 = -1;
                        break;
                    }
                    if(kotlin.jvm.internal.q.b(k1.invoke(((P0.r)listIterator0).next()), k1.invoke(((O0)b00).getValue()))) {
                        break;
                    }
                }
                if(v3 == -1) {
                    p1.add(((O0)b00).getValue());
                }
                else {
                    p1.set(v3, ((O0)b00).getValue());
                }
            }
            if(!k2.c(((O0)b00).getValue()) || !k2.c(t00.c())) {
                p0.a0(916905750);
                k2.a();
                int v4 = p1.size();
                for(int v5 = 0; v5 < v4; ++v5) {
                    Object object1 = p1.get(v5);
                    k2.l(object1, c.e(885640742, p0, new H1(t00, object1, k0, r0, p1, 1)));
                }
                p2 = p1;
                p0.p(false);
            }
            else {
                p0.a0(0x36CE4D57);
                p0.p(false);
                p2 = p1;
            }
            m0 m00 = t00.f();
            boolean z = p0.g(r0);
            boolean z1 = p0.g(m00);
            H h0 = p0.N();
            if(z1 || z || h0 == v2) {
                h0 = (H)k0.invoke(r0);
                p0.l0(h0);
            }
            t0 t01 = r0.a;
            boolean z2 = p0.g(r0);
            b0 b01 = p0.N();
            if(z2 || b01 == v2) {
                b01 = w.s(Boolean.FALSE);
                p0.l0(b01);
            }
            b0 b02 = w.w(h0.d, p0);
            if(kotlin.jvm.internal.q.b(t01.c(), ((O0)t01.d).getValue())) {
                b01.setValue(Boolean.FALSE);
            }
            else if(b02.getValue() != null) {
                b01.setValue(Boolean.TRUE);
            }
            boolean z3 = ((Boolean)b01.getValue()).booleanValue();
            q q1 = r0.n.a;
            if(z3) {
                p0.a0(0xEE1C2B3);
                k3 = k2;
                v6 = v2;
                l00 = w0.b(r0.a, z0.h, null, p0, 0, 2);
                boolean z4 = p0.g(l00);
                q q2 = p0.N();
                if(z4 || q2 == v6) {
                    F.k0 k00 = (F.k0)b02.getValue();
                    q2 = d5.n.p(q1);
                    p0.l0(q2);
                }
                q1 = q2;
                p0.p(false);
            }
            else {
                v6 = v2;
                k3 = k2;
                p0.a0(249942509);
                p0.p(false);
                l00 = null;
            }
            q q3 = q0.then(q1.then(new AnimatedContentTransitionScopeImpl.SizeModifierElement(l00, b02, r0)));
            F.l l1 = p0.N();
            if(l1 == v6) {
                l1 = new F.l(r0);
                p0.l0(l1);
            }
            int v7 = p0.P;
            i0 i00 = p0.m();
            q q4 = r0.a.d(p0, q3);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, l1, j.f);
            w.x(p0, i00, j.e);
            h h1 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h1);
            }
            w.x(p0, q4, j.d);
            p0.a0(0xA723102A);
            int v8 = p2.size();
            for(int v9 = 0; v9 < v8; ++v9) {
                Object object2 = p2.get(v9);
                p0.X(0x71C084D9, k1.invoke(object2));
                we.n n0 = (we.n)k3.g(object2);
                if(n0 == null) {
                    p0.a0(0xC650A4B0);
                }
                else {
                    p0.a0(1908443505);
                    n0.invoke(p0, 0);
                }
                p0.p(false);
                p0.p(false);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new F.i(t00, q0, k0, k1, v, 0);
        }
    }

    public static final void b(Object object0, q q0, k k0, e e0, String s, k k1, l l0, int v) {
        k k2;
        e e1;
        q q1;
        ((androidx.compose.runtime.p)l0).c0(0x7F1EBC6D);
        int v1 = v | (((androidx.compose.runtime.p)l0).g(object0) ? 4 : 2) | 0x30C30;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (0x92493 & v1) != 0x92492)) {
            a.a(w0.e(object0, s, ((androidx.compose.runtime.p)l0), v1 & 14 | 0x30), r0.n.a, k0, F.c.g, ((androidx.compose.runtime.p)l0), 0x36DB0);
            q1 = r0.n.a;
            e1 = d.a;
            k2 = F.c.g;
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
            q1 = q0;
            e1 = e0;
            k2 = k1;
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new y(object0, q1, k0, e1, s, k2, v, 2);
        }
    }
}

