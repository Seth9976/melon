package androidx.compose.foundation;

import B2.s;
import G.s0;
import I.X0;
import I.Z;
import I.u0;
import M.c;
import N0.j;
import P0.h;
import P0.i;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.widget.EdgeEffect;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.draw.a;
import je.x;
import r0.d;
import r0.e;
import r0.n;
import we.k;
import y0.E;
import y0.Q;
import y0.T;
import y0.o;
import y0.t;

public abstract class q {
    public static final y a(long v, float f) {
        return new y(f, new T(v));
    }

    public static final void b(r0.q q0, k k0, l l0, int v) {
        ((p)l0).c0(0xC8660B92);
        int v1 = (v & 6) == 0 ? (((p)l0).g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(k0) ? 0x20 : 16);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            c.d(((p)l0), a.a(q0, k0));
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new s0(q0, k0, v, 3);
        }
    }

    public static final void c(C0.c c0, String s, r0.q q0, e e0, N0.k k0, float f, t t0, l l0, int v, int v1) {
        t t2;
        N0.k k2;
        e e2;
        r0.q q5;
        int v3;
        N0.k k1;
        float f1;
        r0.q q1;
        p p0 = (p)l0;
        p0.c0(0x441D0E20);
        int v2 = (v & 6) == 0 ? (p0.i(c0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
            q1 = q0;
        }
        else if((v & 0x180) == 0) {
            q1 = q0;
            v2 |= (p0.g(q1) ? 0x100 : 0x80);
        }
        else {
            q1 = q0;
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.g(e0) ? 0x800 : 0x400);
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.g(k0) ? 0x4000 : 0x2000);
        }
        if((v1 & 0x20) != 0) {
            v2 |= 0x30000;
            f1 = f;
        }
        else if((0x30000 & v) == 0) {
            f1 = f;
            v2 |= (p0.d(f1) ? 0x20000 : 0x10000);
        }
        else {
            f1 = f;
        }
        if((v1 & 0x40) != 0) {
            v2 |= 0x180000;
        }
        else if((0x180000 & v) == 0) {
            v2 |= (p0.g(t0) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v2 & 1, (v2 & 0x92493) != 0x92492)) {
            r0.q q2 = n.a;
            if((v1 & 4) != 0) {
                q1 = q2;
            }
            e e1 = (v1 & 8) == 0 ? e0 : d.e;
            if((v1 & 16) == 0) {
                v3 = v1 & 0x20;
                k1 = k0;
            }
            else {
                k1 = j.c;
                v3 = v1 & 0x20;
            }
            if(v3 != 0) {
                f1 = 1.0f;
            }
            t t1 = (v1 & 0x40) == 0 ? t0 : null;
            if(s == null) {
                p0.a0(0x3E060CA1);
            }
            else {
                p0.a0(1040425059);
                s s1 = p0.N();
                if((v2 & 0x70) == 0x20 || s1 == androidx.compose.runtime.k.a) {
                    s1 = new s(s, 2);
                    p0.l0(s1);
                }
                q2 = X0.n.c(q2, false, s1);
            }
            p0.p(false);
            r0.q q3 = a.d(d5.n.p(q1.then(q2)), c0, e1, k1, f1, t1, 2);
            int v4 = p0.P;
            r0.q q4 = r0.a.d(p0, q3);
            i0 i00 = p0.m();
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, (d0 this, /* 缺少Lambda参数 */, /* 缺少Lambda参数 */) -> o0.w(r1.a.j(v), r1.a.i(v), x.a, u.h), P0.j.f);
            w.x(p0, i00, P0.j.e);
            w.x(p0, q4, P0.j.d);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            p0.p(true);
            q5 = q1;
            e2 = e1;
            k2 = k1;
            t2 = t1;
        }
        else {
            p0.T();
            q5 = q1;
            e2 = e0;
            k2 = k0;
            t2 = t0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new e0(c0, s, q5, e2, k2, f1, t2, v, v1);
        }
    }

    public static float d(EdgeEffect edgeEffect0, float f, float f1, r1.c c0) {
        float f2 = c0.b();
        double f3 = ((double)M.a) * ((double)(f2 * 51890.199219f));
        int v = Build.VERSION.SDK_INT;
        if(((float)(Math.exp(M.b / M.c * Math.log(((double)(Math.abs(f) * 0.35f)) / f3)) * f3)) <= (v < 0x1F ? 0.0f : androidx.compose.foundation.p.b(edgeEffect0)) * f1) {
            int v1 = ye.a.V(f);
            if(v >= 0x1F) {
                edgeEffect0.onAbsorb(v1);
                return f;
            }
            if(edgeEffect0.isFinished()) {
                edgeEffect0.onAbsorb(v1);
            }
            return f;
        }
        return 0.0f;
    }

    public static r0.q e(r0.q q0, E e0, Q q1, int v) {
        if((v & 2) != 0) {
            q1 = y0.M.a;
        }
        return q0.then(new BackgroundElement(0L, e0, q1, 1));
    }

    public static final r0.q f(r0.q q0, long v, Q q1) {
        return q0.then(new BackgroundElement(v, null, q1, 2));
    }

    public static r0.q g(long v, r0.q q0) {
        return q.f(q0, v, y0.M.a);
    }

    public static r0.q h(r0.q q0, int v, int v1, w0 w00, float f, int v2) {
        if((v2 & 4) != 0) {
            v = 1200;
        }
        if((v2 & 16) != 0) {
            w00 = r0.a;
        }
        if((v2 & 0x20) != 0) {
            f = r0.b;
        }
        return q0.then(new MarqueeModifierElement(((v2 & 1) == 0 ? 0x7FFFFFFF : 3), v, ((v2 & 8) == 0 ? v1 : v), w00, f));
    }

    public static final r0.q i(float f, long v, r0.q q0, Q q1) {
        return q.j(q0, f, new T(v), q1);
    }

    public static final r0.q j(r0.q q0, float f, o o0, Q q1) {
        return q0.then(new BorderModifierNodeElement(f, o0, q1));
    }

    public static final void k(u0 u00, long v) {
        if(u00 == u0.a) {
            if(r1.a.g(v) != 0x7FFFFFFF) {
                return;
            }
            L.a.c("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
            return;
        }
        if(r1.a.h(v) != 0x7FFFFFFF) {
            return;
        }
        L.a.c("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
    }

    public static final r0.q l(r0.q q0, K.l l0, f0 f00, boolean z, String s, X0.i i0, we.a a0) {
        if(f00 instanceof l0) {
            return q0.then(new ClickableElement(l0, ((l0)f00), z, s, i0, a0));
        }
        if(f00 == null) {
            return q0.then(new ClickableElement(l0, null, z, s, i0, a0));
        }
        if(l0 != null) {
            return q0.then(androidx.compose.foundation.i0.a(l0, f00).then(new ClickableElement(l0, null, z, s, i0, a0)));
        }
        A a1 = new A(f00, z, s, i0, a0);
        return q0.then(r0.a.a(n.a, a1));
    }

    public static r0.q m(r0.q q0, K.l l0, f0 f00, boolean z, X0.i i0, we.a a0, int v) {
        if((v & 4) != 0) {
            z = true;
        }
        if((v & 16) != 0) {
            i0 = null;
        }
        return q.l(q0, l0, f00, z, null, i0, a0);
    }

    public static r0.q n(r0.q q0, String s, we.a a0, int v) {
        if((v & 2) != 0) {
            s = null;
        }
        return r0.a.a(q0, new z(s, true, a0));
    }

    public static r0.q o(r0.q q0, K.l l0, String s, X0.i i0, String s1, we.a a0, we.a a1, int v) {
        if((v & 8) != 0) {
            s = null;
        }
        if((v & 16) != 0) {
            i0 = null;
        }
        if((v & 0x20) != 0) {
            s1 = null;
        }
        return (v & 0x40) == 0 ? q0.then(new CombinedClickableElement(l0, i0, s, s1, a1, a0)) : q0.then(new CombinedClickableElement(l0, i0, s, s1, a1, null));
    }

    public static final r0.q p(r0.q q0) {
        return q0.then(FocusGroupElement.a);
    }

    // 去混淆评级： 低(20)
    public static final r0.q q(r0.q q0, boolean z, K.l l0) {
        return z ? q0.then(new FocusableElement(l0)) : q0.then(n.a);
    }

    public static r0.q r(r0.q q0, K.l l0) {
        return q0.then(new HoverableElement(l0));
    }

    // 去混淆评级： 低(25)
    public static final boolean s(KeyEvent keyEvent0) {
        long v = H0.e.J(keyEvent0);
        return ((H0.c.a(v, H0.c.f) ? true : H0.c.a(v, H0.c.i)) ? true : H0.c.a(v, H0.c.m)) ? true : H0.c.a(v, H0.c.h);
    }

    public static final Q0 t(l l0) {
        d5.l l1 = Q0.i;
        boolean z = ((p)l0).e(0);
        h0 h00 = ((p)l0).N();
        if(z || h00 == androidx.compose.runtime.k.a) {
            h00 = new h0(0, 2);
            ((p)l0).l0(h00);
        }
        return (Q0)d5.w.P(new Object[0], l1, null, h00, ((p)l0), 0, 4);
    }

    // 去混淆评级： 低(20)
    public static r0.q u(r0.q q0, Q0 q00, boolean z, boolean z1) {
        return z1 ? q.v(q0, q00, u0.a, z, false, null, q00.c, true, null, null).then(new ScrollingLayoutElement(q00, true)) : q.v(q0, q00, u0.b, z, false, null, q00.c, true, null, null).then(new ScrollingLayoutElement(q00, false));
    }

    public static final r0.q v(r0.q q0, X0 x00, u0 u00, boolean z, boolean z1, Z z2, K.l l0, boolean z3, m m0, Q.o o0) {
        return u00 == u0.a ? q0.then(d5.n.o(n.a, X.d)).then(new ScrollingContainerElement(o0, z2, u00, x00, l0, m0, z, z1, z3)) : q0.then(d5.n.o(n.a, X.b)).then(new ScrollingContainerElement(o0, z2, u00, x00, l0, m0, z, z1, z3));
    }

    public static final long w(long v, float f) {
        return ((long)Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat(((int)(v >> 0x20))) - f))) << 0x20 | ((long)Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - f))) & 0xFFFFFFFFL;
    }

    public static r0.q x(r0.q q0, Q0 q00, boolean z, int v) {
        if((v & 2) != 0) {
            z = true;
        }
        return q.u(q0, q00, z, true);
    }
}

