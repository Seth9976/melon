package j5;

import M.c;
import M.s;
import P0.h;
import Q0.w0;
import android.content.Context;
import android.os.Trace;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.runtime.z0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.compose.ContentPainterElement;
import coil.request.ImageRequest.Builder;
import gd.R7;
import r0.d;
import r0.e;
import r0.i;
import r0.q;
import t5.j;
import we.k;
import y0.t;

public abstract class n {
    public static final m a;
    public static final u b;

    static {
        n.a = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        n.b = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final void a(o o0, String s, q q0, k k0, k k1, e e0, N0.k k2, t t0, l l0, int v, int v1) {
        ((p)l0).c0(0xE6DF013B);
        int v2 = (v & 14) == 0 ? (((p)l0).g(o0) ? 4 : 2) | v : v;
        if((v & 0x70) == 0) {
            v2 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v & 0x380) == 0) {
            v2 |= (((p)l0).g(q0) ? 0x100 : 0x80);
        }
        if((v & 0x1C00) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x800 : 0x400);
        }
        if((v & 0xE000) == 0) {
            v2 |= (((p)l0).i(k1) ? 0x4000 : 0x2000);
        }
        if((v & 0x70000) == 0) {
            v2 |= (((p)l0).g(e0) ? 0x20000 : 0x10000);
        }
        if((v & 0x380000) == 0) {
            v2 |= (((p)l0).g(k2) ? 0x100000 : 0x80000);
        }
        if((v & 0x1C00000) == 0) {
            v2 |= (((p)l0).d(1.0f) ? 0x800000 : 0x400000);
        }
        if((0xE000000 & v) == 0) {
            v2 |= (((p)l0).g(t0) ? 0x4000000 : 0x2000000);
        }
        if((v & 0x70000000) == 0) {
            v2 |= (((p)l0).e(1) ? 0x20000000 : 0x10000000);
        }
        int v3 = (v1 & 14) == 0 ? v1 | (((p)l0).h(true) ? 4 : 2) : v1;
        if((0x5B6DB6DB & v2) != 306783378 || (v3 & 11) != 2 || !((p)l0).D()) {
            j j0 = A.b(o0.a, k2, ((p)l0));
            j5.l l1 = n.h(j0, o0.c, k0, k1, k2, 1, ((p)l0), 0);
            n.c((j0.y instanceof r ? q0.then(((q)j0.y)) : q0), l1, s, e0, k2, t0, ((p)l0), v2 << 3 & 0x380 | v2 >> 6 & 0x1C00 | v2 >> 6 & 0xE000 | v2 >> 6 & 0x70000 | v2 >> 6 & 0x380000 | v3 << 21 & 0x1C00000);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new a(o0, s, q0, k0, k1, e0, k2, t0, v, v1);
        }
    }

    public static final void b(Object object0, String s, q q0, i i0, N0.k k0, y0.k k1, l l0, int v, int v1) {
        ((p)l0).b0(1451072229);
        i i1 = (v1 & 0x20) == 0 ? i0 : d.e;
        N0.k k2 = (v1 & 0x40) == 0 ? k0 : N0.j.c;
        i5.e e0 = n.g(v.a, ((p)l0));
        int v2 = v & 0x70 | 520 | v << 3 & 0x1C00 | v << 3 & 0xE000 | v << 3 & 0x70000 | v << 3 & 0x380000 | v << 3 & 0x1C00000 | v << 3 & 0xE000000 | v << 3 & 0x70000000;
        ((p)l0).b0(2032051394);
        n.a(new o(object0, n.b, e0), s, q0, j5.l.r, null, i1, k2, ((v1 & 0x100) == 0 ? k1 : null), ((p)l0), v2 & 0x70 | v2 >> 3 & 0x380 | v2 >> 3 & 0x1C00 | 0xE000 & v2 >> 3 | v2 >> 3 & 0x70000 | v2 >> 3 & 0x380000 | v2 >> 3 & 0x1C00000 | v2 >> 3 & 0xE000000 | (v >> 27 & 14) << 27 & 0x70000000, 0);
        ((p)l0).p(false);
        ((p)l0).p(false);
    }

    public static final void c(q q0, j5.l l0, String s, e e0, N0.k k0, t t0, l l1, int v) {
        p p0 = (p)l1;
        p0.c0(0x2E5BE4E8);
        int v1 = (v & 14) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x70) == 0) {
            v1 |= (p0.g(l0) ? 0x20 : 16);
        }
        if((v & 0x380) == 0) {
            v1 |= (p0.g(s) ? 0x100 : 0x80);
        }
        if((v & 0x1C00) == 0) {
            v1 |= (p0.g(e0) ? 0x800 : 0x400);
        }
        if((0xE000 & v) == 0) {
            v1 |= (p0.g(k0) ? 0x4000 : 0x2000);
        }
        if((0x70000 & v) == 0) {
            v1 |= (p0.d(1.0f) ? 0x20000 : 0x10000);
        }
        if((0x380000 & v) == 0) {
            v1 |= (p0.g(t0) ? 0x100000 : 0x80000);
        }
        if((0x1C00000 & v) == 0) {
            v1 |= (p0.h(true) ? 0x800000 : 0x400000);
        }
        if((v1 & 0x16DB6DB) != 4793490 || !p0.D()) {
            q q1 = d5.n.p((s == null ? q0 : X0.n.c(q0, false, new com.iloen.melon.playback.playlist.db.d(s, 13)))).then(new ContentPainterElement(l0, e0, k0, 1.0f, t0));
            b b0 = b.b;
            p0.b0(0x207BAF9A);
            int v2 = p0.P;
            q q2 = r0.a.d(p0, q1);
            i0 i00 = p0.m();
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.b0(1405779621);
            p0.e0();
            if(p0.O) {
                p0.l(new b0.u(2, i0));
            }
            else {
                p0.o0();
            }
            w.x(p0, b0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            w.x(p0, q2, P0.j.d);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            A7.d.s(p0, true, false, false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.n0(q0, l0, s, e0, k0, t0, v);
        }
    }

    public static final void d(j j0, String s, q q0, m0.b b0, m0.b b1, k k0, k k1, e e0, N0.k k2, float f, t t0, int v, l l0, int v1, int v2, int v3) {
        ((p)l0).b0(0xA347D002);
        k k3 = (v3 & 0x200) == 0 ? k1 : null;
        e e1 = (v3 & 0x400) == 0 ? e0 : d.e;
        N0.k k4 = (v3 & 0x800) == 0 ? k2 : N0.j.c;
        i5.e e2 = n.g(v.a, ((p)l0));
        int v4 = v1 & 0x70 | 520 | v1 << 3 & 0x1C00 | v1 << 3 & 0xE000 | v1 << 3 & 0x70000 | v1 << 3 & 0x380000 | v1 << 3 & 0x1C00000 | v1 << 3 & 0xE000000 | v1 << 3 & 0x70000000;
        int v5 = v2 << 3 & 0x1C00000 | (v1 >> 27 & 14 | v2 << 3 & 0x70 | v2 << 3 & 0x380 | v2 << 3 & 0x1C00 | v2 << 3 & 0xE000 | v2 << 3 & 0x70000 | v2 << 3 & 0x380000);
        ((p)l0).b0(0xA3E6C4A1);
        o o0 = new o(j0, n.b, e2);
        R7 r70 = k0 != null || k3 != null ? new R7(10, k0, k3) : null;
        m0.b b2 = new m0.b(0x2CBFDCE0, new Ac.l(25, ((v3 & 16) == 0 ? b0 : null), b1), true);
        n.e(o0, s, q0, j5.l.r, r70, e1, k4, ((v3 & 0x1000) == 0 ? f : 1.0f), ((v3 & 0x2000) == 0 ? t0 : null), ((v3 & 0x4000) == 0 ? v : 1), b2, ((p)l0), v4 & 0x70 | v4 >> 3 & 0x380 | v4 >> 3 & 0x1C00 | v5 << 12 & 0x70000 | v5 << 12 & 0x380000 | v5 << 12 & 0x1C00000 | v5 << 12 & 0xE000000 | v5 << 12 & 0x70000000, v5 >> 18 & 14);
        ((p)l0).p(false);
        ((p)l0).p(false);
    }

    public static final void e(o o0, String s, q q0, k k0, k k1, e e0, N0.k k2, float f, t t0, int v, m0.b b0, l l0, int v1, int v2) {
        p p0 = (p)l0;
        p0.c0(0xDBE6AFBB);
        int v3 = (v1 & 14) == 0 ? (p0.g(o0) ? 4 : 2) | v1 : v1;
        int v4 = 16;
        if((v1 & 0x70) == 0) {
            v3 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v1 & 0x380) == 0) {
            v3 |= (p0.g(q0) ? 0x100 : 0x80);
        }
        if((v1 & 0x1C00) == 0) {
            v3 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if((0xE000 & v1) == 0) {
            v3 |= (p0.i(k1) ? 0x4000 : 0x2000);
        }
        if((0x70000 & v1) == 0) {
            v3 |= (p0.g(e0) ? 0x20000 : 0x10000);
        }
        if((0x380000 & v1) == 0) {
            v3 |= (p0.g(k2) ? 0x100000 : 0x80000);
        }
        if((0x1C00000 & v1) == 0) {
            v3 |= (p0.d(f) ? 0x800000 : 0x400000);
        }
        if((v1 & 0xE000000) == 0) {
            v3 |= (p0.g(t0) ? 0x4000000 : 0x2000000);
        }
        if((v1 & 0x70000000) == 0) {
            v3 |= (p0.e(v) ? 0x20000000 : 0x10000000);
        }
        int v5 = (v2 & 14) == 0 ? v2 | (p0.h(true) ? 4 : 2) : v2;
        if((v2 & 0x70) == 0) {
            if(p0.i(b0)) {
                v4 = 0x20;
            }
            v5 |= v4;
        }
        if((0x5B6DB6DB & v3) != 306783378 || (v5 & 91) != 18 || !p0.D()) {
            j j0 = A.b(o0.a, k2, p0);
            j5.l l1 = n.h(j0, o0.c, k0, k1, k2, v, p0, 0x40);
            u5.h h0 = j0.y;
            if(h0 instanceof r) {
                p0.b0(0x840FF3E8);
                c.a(q0, e0, true, m0.c.b(0xCB0F4901, p0, new z(h0, b0, l1, s, e0, k2, f, t0)), p0, v3 >> 6 & 14 | 0xD80 | v3 >> 12 & 0x70, 0);
            }
            else {
                p0.b0(-2080018031);
                p0.b0(0x2BB5B5D7);
                int v6 = (v3 >> 6 & 14 | 0x180 | v3 >> 12 & 0x70) >> 3 & 14 | 0x30;
                kotlin.jvm.internal.q.b(e0, d.a);
                p0.a0(-1709737635);
                boolean z = (v6 & 14 ^ 6) > 4 && p0.g(e0) || (v6 & 6) == 4;
                s s1 = p0.N();
                if(z || s1 == androidx.compose.runtime.k.a) {
                    s1 = new s(e0, true);
                    p0.l0(s1);
                }
                p0.p(false);
                p0.b0(-1323940314);
                int v7 = p0.P;
                i0 i00 = p0.m();
                P0.k.y.getClass();
                P0.i i0 = P0.j.b;
                m0.b b1 = new m0.b(0xA173A20C, new F.d(q0, 3), true);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, s1, P0.j.f);
                w.x(p0, i00, P0.j.e);
                h h1 = P0.j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h1);
                }
                b1.invoke(new z0(p0), p0, 0);
                p0.b0(2058660585);
                b0.invoke(new j5.w((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)), l1, s, e0, k2, f, t0), p0, ((int)(v5 & 0x70)));
                p0.p(false);
                p0.p(true);
                p0.p(false);
                p0.p(false);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new y(o0, s, q0, k0, k1, e0, k2, f, t0, v, b0, v1, v2);
        }
    }

    public static final void f(j5.w w0, q q0, C0.c c0, String s, e e0, N0.k k0, float f, t t0, boolean z, l l0, int v) {
        boolean z1;
        t t1;
        float f1;
        N0.k k1;
        e e1;
        String s1;
        q q1;
        boolean z2;
        C0.c c1;
        q q2;
        p p0 = (p)l0;
        p0.c0(880638523);
        int v1 = (v & 14) == 0 ? (p0.g(w0) ? 4 : 2) | v : v;
        int v2 = (v & 0x1C00) == 0 ? v1 | 1200 : v1 | 0xB0;
        if((0xE000 & v) == 0) {
            v2 |= 0x2000;
        }
        if((0x70000 & v) == 0) {
            v2 |= 0x10000;
        }
        if((0x380000 & v) == 0) {
            v2 |= 0x80000;
        }
        if((0x1C00000 & v) == 0) {
            v2 |= 0x400000;
        }
        if((0xE000000 & v) == 0) {
            v2 |= 0x2000000;
        }
        if((0xB6DB6DB & v2) != 0x2492492 || !p0.D()) {
            p0.V();
            if((v & 1) == 0 || p0.B()) {
                c1 = w0.b;
                s1 = w0.c;
                e1 = w0.d;
                k1 = w0.e;
                f1 = w0.f;
                t1 = w0.g;
                w0.getClass();
                q2 = r0.n.a;
                z2 = true;
            }
            else {
                p0.T();
                q2 = q0;
                c1 = c0;
                s1 = s;
                e1 = e0;
                k1 = k0;
                f1 = f;
                t1 = t0;
                z2 = z;
            }
            p0.q();
            q q3 = s1 == null ? q2 : X0.n.c(q2, false, new com.iloen.melon.playback.playlist.db.d(s1, 13));
            if(z2) {
                q3 = d5.n.p(q3);
            }
            q q4 = q3.then(new ContentPainterElement(c1, e1, k1, f1, t1));
            b b0 = b.c;
            p0.b0(0x207BAF9A);
            int v3 = p0.P;
            q q5 = r0.a.d(p0, q4);
            i0 i00 = p0.m();
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
            p0.b0(1405779621);
            p0.e0();
            if(p0.O) {
                c0 = c1;
                p0.l(new b0.u(3, i0));
            }
            else {
                c0 = c1;
                p0.o0();
            }
            w.x(p0, b0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            w.x(p0, q5, P0.j.d);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            A7.d.s(p0, true, false, false);
            q1 = q2;
            z1 = z2;
        }
        else {
            p0.T();
            q1 = q0;
            s1 = s;
            e1 = e0;
            k1 = k0;
            f1 = f;
            t1 = t0;
            z1 = z;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new x(w0, q1, c0, s1, e1, k1, f1, t1, z1, v);
        }
    }

    public static final i5.e g(l0 l00, l l0) {
        i5.e e0 = (i5.e)((p)l0).k(l00);
        return e0 == null ? i5.a.a(((Context)((p)l0).k(AndroidCompositionLocals_androidKt.b))) : e0;
    }

    public static final j5.l h(j j0, i5.e e0, k k0, k k1, N0.k k2, int v, l l0, int v1) {
        j5.l l1;
        ((p)l0).b0(0x62169369);
        ((p)l0).b0(952940650);
        Trace.beginSection("rememberAsyncImagePainter");
        try {
            j j1 = A.a(j0, ((p)l0));
            n.j(j1);
            ((p)l0).b0(0x413FABBD);
            l1 = ((p)l0).N();
            if(l1 == androidx.compose.runtime.k.a) {
                l1 = new j5.l(j1, e0);
                ((p)l0).l0(l1);
            }
            ((p)l0).p(false);
            l1.h = k0;
            l1.i = k1;
            l1.j = k2;
            l1.k = v;
            l1.l = ((Boolean)((p)l0).k(w0.a)).booleanValue();
            ((O0)l1.o).setValue(e0);
            ((O0)l1.n).setValue(j1);
            l1.c();
            ((p)l0).p(false);
        }
        finally {
            Trace.endSection();
        }
        ((p)l0).p(false);
        return l1;
    }

    public static void i(String s) {
        throw new IllegalArgumentException("Unsupported type: " + s + ". " + ("If you wish to display this " + s + ", use androidx.compose.foundation.Image."));
    }

    public static final void j(j j0) {
        Object object0 = j0.b;
        if(object0 instanceof ImageRequest.Builder) {
            throw new IllegalArgumentException("Unsupported type: ImageRequest.Builder. Did you forget to call ImageRequest.Builder.build()?");
        }
        if(!(object0 instanceof y0.e)) {
            if(!(object0 instanceof D0.e)) {
                if(!(object0 instanceof C0.c)) {
                    if(j0.c != null) {
                        throw new IllegalArgumentException("request.target must be null.");
                    }
                    return;
                }
                n.i("Painter");
                throw null;
            }
            n.i("ImageVector");
            throw null;
        }
        n.i("ImageBitmap");
        throw null;
    }
}

