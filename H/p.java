package H;

import M.Y;
import M.g;
import M.p0;
import M.w;
import M.y;
import M.z;
import P0.h;
import P0.i;
import P0.k;
import T.d;
import T.e;
import U.b0;
import a1.U;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import m0.b;
import r0.n;
import v1.q;
import v1.r;
import y0.M;
import y0.s;

public abstract class p {
    public static final q a;
    public static final c b;

    static {
        p.a = new q(true, r.a, true);
        long v = s.c(s.b, 0.38f);
        long v1 = s.c(s.b, 0.38f);
        p.b = new c(s.c, s.b, s.b, v, v1);
    }

    public static final void a(c c0, b b0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0xC916B2E3);
        int v1 = p0.g(c0) ? 4 : 2;
        n n0 = n.a;
        int v2 = v1 | v | (p0.g(n0) ? 0x20 : 16);
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            d d0 = e.b(j.e);
            r0.q q0 = androidx.compose.foundation.q.x(a.l(a.p(androidx.compose.foundation.q.f(d8.d.F(n0, j.d, d0, 28), c0.a, M.a), Y.b), 0.0f, j.i, 1), androidx.compose.foundation.q.t(p0), false, 14);
            y y0 = w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            b0.invoke(z.a, p0, 54);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new B2.p(c0, b0, v, 2);
        }
    }

    public static final void b(String s, c c0, we.a a0, l l0, int v) {
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x2F25FB7F);
        int v1 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.h(true) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.g(c0) ? 0x100 : 0x80);
        }
        n n0 = n.a;
        if((v & 0xC00) == 0) {
            v1 |= (p0.g(n0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (p0.i(null) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v1 |= (p0.i(a0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            r0.h h0 = j.f;
            float f = j.h;
            g g0 = M.j.h(f);
            o o0 = p0.N();
            if((((v1 & 0x70) == 0x20 ? 1 : 0) | ((0x70000 & v1) == 0x20000 ? 1 : 0)) != 0 || o0 == androidx.compose.runtime.k.a) {
                o0 = new o(0, a0);
                p0.l0(o0);
            }
            r0.q q0 = a.l(androidx.compose.foundation.layout.d.p(androidx.compose.foundation.layout.d.f(androidx.compose.foundation.q.n(n0, s, o0, 4), 1.0f), j.a, j.c, j.b, j.c), f, 0.0f, 2);
            p0 p00 = M.n0.a(g0, h0, p0, 54);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h1 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h1);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            p0.a0(0x2111652D);
            p0.p(false);
            U u0 = new U(c0.b, j.j, j.k, null, j.m, null, j.g, j.l, 0xFD7F78);
            b0.c(s, new LayoutWeightElement(1.0f, true), u0, null, 0, false, 1, 0, null, p0, v1 & 14 | 0x180000, 952);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H.a(s, c0, a0, v);
        }
    }

    public static final void c(v1.p p0, we.a a0, F.g g0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(712057293);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(p0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).g(n.a) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(g0) ? 0x800 : 0x400);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            Context context0 = (Context)((androidx.compose.runtime.p)l0).k(AndroidCompositionLocals_androidKt.b);
            Configuration configuration0 = (Configuration)((androidx.compose.runtime.p)l0).k(AndroidCompositionLocals_androidKt.a);
            boolean z = ((androidx.compose.runtime.p)l0).g(context0);
            boolean z1 = ((androidx.compose.runtime.p)l0).g(configuration0);
            c c0 = ((androidx.compose.runtime.p)l0).N();
            if(z1 || z || c0 == androidx.compose.runtime.k.a) {
                c c1 = p.b;
                long v2 = c1.a;
                TypedArray typedArray0 = context0.obtainStyledAttributes(0x1030086, new int[]{0x1010031});
                int v3 = M.z(v2);
                int v4 = typedArray0.getColor(0, v3);
                typedArray0.recycle();
                if(v4 != v3) {
                    v2 = ((long)v4) << 0x20;
                }
                TypedArray typedArray1 = context0.obtainStyledAttributes(0x1030080, new int[]{0x1010036});
                ColorStateList colorStateList0 = typedArray1.getColorStateList(0);
                typedArray1.recycle();
                long v5 = c1.b;
                int v6 = M.z(v5);
                Integer integer0 = null;
                Integer integer1 = colorStateList0 == null ? null : colorStateList0.getColorForState(new int[]{0x101009E}, v6);
                if(integer1 != null && ((int)integer1) != v6) {
                    v5 = ((long)(((int)integer1))) << 0x20;
                }
                long v7 = c1.d;
                int v8 = M.z(v7);
                if(colorStateList0 != null) {
                    integer0 = colorStateList0.getColorForState(new int[]{0xFEFEFF62}, v8);
                }
                if(integer0 != null && ((int)integer0) != v8) {
                    v7 = ((long)(((int)integer0))) << 0x20;
                }
                c c2 = new c(v2, v5, v5, v7, v7);
                ((androidx.compose.runtime.p)l0).l0(c2);
                c0 = c2;
            }
            p.d(p0, a0, c0, g0, ((androidx.compose.runtime.p)l0), v1 & 0x3FE | v1 << 3 & 0xE000);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new H.a(p0, a0, g0, v);
        }
    }

    public static final void d(v1.p p0, we.a a0, c c0, F.g g0, l l0, int v) {
        ((androidx.compose.runtime.p)l0).c0(0x56425B5B);
        int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)l0).g(p0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).g(n.a) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).g(c0) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v1 |= (((androidx.compose.runtime.p)l0).i(g0) ? 0x4000 : 0x2000);
        }
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 9363) != 9362)) {
            b b0 = m0.c.e(0x2F709E7D, ((androidx.compose.runtime.p)l0), new B2.p(c0, g0));
            v1.i.a(p0, a0, p.a, b0, ((androidx.compose.runtime.p)l0), v1 & 14 | 0xD80 | v1 & 0x70, 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new F.i(p0, a0, c0, g0, v);
        }
    }
}

