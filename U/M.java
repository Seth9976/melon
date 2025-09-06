package U;

import G.g;
import a1.U;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import f1.E;
import f1.F;
import f1.j;
import f1.x;
import m0.b;
import r0.q;
import we.k;
import we.o;
import y0.T;

public abstract class m {
    static {
    }

    public static final void a(x x0, k k0, q q0, boolean z, U u0, e0 e00, d0 d00, int v, int v1, F f0, k k1, T t0, b b0, l l0, int v2, int v3) {
        p p0 = (p)l0;
        p0.c0(1804514146);
        int v4 = (v2 & 6) == 0 ? (p0.g(x0) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v4 |= (p0.i(k0) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v4 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        int v5 = 0x800;
        if((v2 & 0xC00) == 0) {
            v4 |= (p0.h(z) ? 0x800 : 0x400);
        }
        int v6 = 0x2000;
        if((v2 & 0x6000) == 0) {
            v4 |= (p0.h(false) ? 0x4000 : 0x2000);
        }
        int v7 = 0x10000;
        if((v2 & 0x30000) == 0) {
            v4 |= (p0.g(u0) ? 0x20000 : 0x10000);
        }
        if((v2 & 0x180000) == 0) {
            v4 |= (p0.g(e00) ? 0x100000 : 0x80000);
        }
        if((v2 & 0xC00000) == 0) {
            v4 |= (p0.g(d00) ? 0x800000 : 0x400000);
        }
        if((v2 & 0x6000000) == 0) {
            v4 |= (p0.h(false) ? 0x4000000 : 0x2000000);
        }
        if((v2 & 0x30000000) == 0) {
            v4 |= (p0.e(v) ? 0x20000000 : 0x10000000);
        }
        int v8 = (v3 & 6) == 0 ? v3 | (p0.e(v1) ? 4 : 2) : v3;
        if((v3 & 0x30) == 0) {
            v8 |= (p0.g(f0) ? 0x20 : 16);
        }
        if((v3 & 0x180) == 0) {
            v8 |= (p0.i(k1) ? 0x100 : 0x80);
        }
        if((v3 & 0xC00) == 0) {
            if(!p0.g(null)) {
                v5 = 0x400;
            }
            v8 |= v5;
        }
        if((v3 & 0x6000) == 0) {
            if(p0.g(t0)) {
                v6 = 0x4000;
            }
            v8 |= v6;
        }
        if((v3 & 0x30000) == 0) {
            if(p0.i(b0)) {
                v7 = 0x20000;
            }
            v8 |= v7;
        }
        int v9 = 1;
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (v8 & 74899) != 74898)) {
            p0.V();
            if((v2 & 1) != 0 && !p0.B()) {
                p0.T();
            }
            p0.q();
            j j0 = e00.a(false);
            if((v4 & 0x70) != 0x20) {
                v9 = 0;
            }
            Ld.p p1 = p0.N();
            if((((v4 & 14) == 4 ? 1 : 0) | v9) != 0 || p1 == androidx.compose.runtime.k.a) {
                p1 = new Ld.p(13, x0, k0);
                p0.l0(p1);
            }
            b0.f(x0, p1, q0, u0, f0, k1, t0, true, v, v1, j0, d00, z, b0, p0, v4 & 910 | v4 >> 6 & 0x1C00 | v8 << 9 & 0xE000 | v8 << 9 & 0x70000 | v8 << 9 & 0x380000 | v8 << 9 & 0x1C00000, v4 & 0x1C00 | v4 >> 15 & 0x380 | v4 & 0xE000 | v8 & 0x70000);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U.j(x0, k0, q0, z, u0, e00, d00, v, v1, f0, k1, t0, b0, v2, v3);
        }
    }

    public static final void b(String s, k k0, q q0, boolean z, U u0, e0 e00, d0 d00, boolean z1, int v, int v1, F f0, k k1, T t0, o o0, l l0, int v2, int v3, int v4) {
        o o2;
        boolean z7;
        d0 d03;
        k k4;
        F f3;
        e0 e02;
        int v16;
        boolean z4;
        int v15;
        int v13;
        e0 e01;
        d0 d02;
        o o1;
        k k2;
        F f1;
        boolean z3;
        int v12;
        int v11;
        int v10;
        int v9;
        d0 d01;
        p p0 = (p)l0;
        p0.c0(0x3857730F);
        int v5 = (v2 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v5 |= (p0.i(k0) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v5 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        int v6 = 0x400;
        if((v4 & 8) != 0) {
            v5 |= 0xC00;
        }
        else if((v2 & 0xC00) == 0) {
            v5 |= (p0.h(z) ? 0x800 : 0x400);
        }
        int v7 = 0x2000;
        if((v4 & 16) != 0) {
            v5 |= 0x6000;
        }
        else if((v2 & 0x6000) == 0) {
            v5 |= (p0.h(false) ? 0x4000 : 0x2000);
        }
        int v8 = 0x10000;
        if((v2 & 0x30000) == 0) {
            v5 |= (p0.g(u0) ? 0x20000 : 0x10000);
        }
        if((v4 & 0x40) != 0) {
            v5 |= 0x180000;
        }
        else if((v2 & 0x180000) == 0) {
            v5 |= (p0.g(e00) ? 0x100000 : 0x80000);
        }
        if((v4 & 0x80) == 0) {
            d01 = d00;
            if((v2 & 0xC00000) == 0) {
                v5 |= (p0.g(d01) ? 0x800000 : 0x400000);
            }
        }
        else {
            v5 |= 0xC00000;
            d01 = d00;
        }
        if((v2 & 0x6000000) == 0) {
            v5 |= (p0.h(z1) ? 0x4000000 : 0x2000000);
        }
        if((v2 & 0x30000000) == 0) {
            v5 |= (p0.e(v) ? 0x20000000 : 0x10000000);
        }
        if((v4 & 0x400) != 0) {
            v9 = v3 | 6;
            v10 = v4 & 0x400;
        }
        else if((v3 & 6) == 0) {
            v10 = v4 & 0x400;
            v9 = v3 | (p0.e(v1) ? 4 : 2);
        }
        else {
            v10 = v4 & 0x400;
            v9 = v3;
        }
        if((v4 & 0x800) != 0) {
            v9 |= 0x30;
            v11 = v4 & 0x800;
        }
        else if((v3 & 0x30) == 0) {
            v11 = v4 & 0x800;
            v9 |= (p0.g(f0) ? 0x20 : 16);
        }
        else {
            v11 = v4 & 0x800;
        }
        if((v4 & 0x1000) == 0) {
            v12 = (v3 & 0x180) == 0 ? v9 | (p0.i(k1) ? 0x100 : 0x80) : v9;
        }
        else {
            v12 = v9 | 0x180;
        }
        if((v4 & 0x2000) != 0) {
            v12 |= 0xC00;
        }
        else if((v3 & 0xC00) == 0) {
            if(p0.g(null)) {
                v6 = 0x800;
            }
            v12 |= v6;
        }
        if((v3 & 0x6000) == 0) {
            if(p0.g(t0)) {
                v7 = 0x4000;
            }
            v12 |= v7;
        }
        if((v4 & 0x8000) != 0) {
            v12 |= 0x30000;
        }
        else if((v3 & 0x30000) == 0) {
            if(p0.i(o0)) {
                v8 = 0x20000;
            }
            v12 |= v8;
        }
        boolean z2 = true;
        if(p0.Q(v5 & 1, (v5 & 306783379) != 306783378 || (74899 & v12) != 74898)) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                z3 = (v4 & 8) == 0 ? z : true;
                e01 = (v4 & 0x40) == 0 ? e00 : e0.e;
                if((v4 & 0x80) != 0) {
                    d01 = d0.c;
                }
                v13 = v10 == 0 ? v1 : 1;
                F f2 = v11 == 0 ? f0 : E.a;
                k k3 = (v4 & 0x1000) == 0 ? k1 : U.k.g;
                if((v4 & 0x8000) == 0) {
                    o1 = o0;
                    d02 = d01;
                    f1 = f2;
                    k2 = k3;
                }
                else {
                    d02 = d01;
                    f1 = f2;
                    k2 = k3;
                    o1 = t.a;
                }
            }
            else {
                p0.T();
                z3 = z;
                f1 = f0;
                k2 = k1;
                o1 = o0;
                d02 = d01;
                e01 = e00;
                v13 = v1;
            }
            p0.q();
            androidx.compose.runtime.b0 b00 = p0.N();
            V v14 = androidx.compose.runtime.k.a;
            if(b00 == v14) {
                v15 = v13;
                z4 = z3;
                b00 = w.s(new x(s, 0L, 6));
                p0.l0(b00);
            }
            else {
                z4 = z3;
                v15 = v13;
            }
            x x0 = x.b(((x)b00.getValue()), s);
            boolean z5 = p0.g(x0);
            g g0 = p0.N();
            if(z5 || g0 == v14) {
                g0 = new g(17, x0, b00);
                p0.l0(g0);
            }
            J.h(g0, p0);
            androidx.compose.runtime.b0 b01 = p0.N();
            if((v5 & 14) == 4 || b01 == v14) {
                b01 = w.s(s);
                p0.l0(b01);
            }
            j j0 = e01.a(z1);
            boolean z6 = p0.g(b01);
            if((v5 & 0x70) != 0x20) {
                z2 = false;
            }
            F.g g1 = p0.N();
            if(z6 || z2 || g1 == v14) {
                g1 = new F.g(k0, b00, b01, 11);
                p0.l0(g1);
            }
            b0.f(x0, g1, q0, u0, f1, k2, t0, !z1, (z1 ? 1 : v), (z1 ? 1 : v15), j0, d02, z4, o1, p0, v5 & 0x380 | v5 >> 6 & 0x1C00 | v12 << 9 & 0xE000 | v12 << 9 & 0x70000 | 0x380000 & v12 << 9 | v12 << 9 & 0x1C00000, v5 >> 15 & 0x380 | v5 & 0x1C00 | v5 & 0xE000 | v12 & 0x70000);
            v16 = v15;
            e02 = e01;
            f3 = f1;
            k4 = k2;
            d03 = d02;
            z7 = z4;
            o2 = o1;
        }
        else {
            p0.T();
            z7 = z;
            v16 = v1;
            o2 = o0;
            d03 = d01;
            e02 = e00;
            f3 = f0;
            k4 = k1;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U.l(s, k0, q0, z7, u0, e02, d03, z1, v, v16, f3, k4, t0, o2, v2, v3, v4);
        }
    }
}

