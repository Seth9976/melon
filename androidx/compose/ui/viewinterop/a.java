package androidx.compose.ui.viewinterop;

import A7.d;
import Df.u;
import E4.g;
import F.I;
import J2.f;
import P0.F0;
import P0.h;
import P0.j;
import Q0.k0;
import Q2.e;
import android.content.Context;
import android.view.View;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.focus.FocusTargetNode.FocusTargetElement;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.D;
import k8.Y;
import o0.i;
import r0.n;
import r0.q;
import r1.c;
import r1.m;
import u1.o;
import we.k;

public abstract class a {
    public static final void a(k k0, q q0, k k1, l l0, int v, int v1) {
        q q2;
        k k3;
        u1.a a0 = u1.a.l;
        ((p)l0).c0(0x95ADE287);
        int v2 = (v & 6) == 0 ? (((p)l0).i(k0) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (((p)l0).g(q0) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (((p)l0).i(k1) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            q q1 = (v1 & 2) == 0 ? q0 : n.a;
            k k2 = (v1 & 4) == 0 ? k1 : a0;
            a.b(k0, q1, null, a0, k2, ((p)l0), v2 & 14 | 0xC00 | v2 & 0x70 | v2 << 6 & 0xE000, 4);
            k3 = k2;
            q2 = q1;
        }
        else {
            ((p)l0).T();
            q2 = q0;
            k3 = k1;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new f(v, v1, 4, k3, k0, q2);
        }
    }

    public static final void b(k k0, q q0, k k1, k k2, k k3, l l0, int v, int v1) {
        k k5;
        k k4;
        p p0 = (p)l0;
        p0.c0(-180024211);
        u u0 = p0.a;
        int v2 = (v & 6) == 0 ? (p0.i(k0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(q0) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
            k4 = k1;
        }
        else if((v & 0x180) == 0) {
            k4 = k1;
            v2 |= (p0.i(k4) ? 0x100 : 0x80);
        }
        else {
            k4 = k1;
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.i(k2) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.i(k3) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            if((v1 & 4) != 0) {
                k4 = null;
            }
            int v3 = p0.P;
            q q1 = r0.a.d(p0, q0.then(FocusGroupPropertiesElement.a).then(FocusTargetNode.FocusTargetElement.a).then(FocusTargetPropertiesElement.a).then(FocusTargetNode.FocusTargetElement.a));
            c c0 = (c)p0.k(k0.h);
            m m0 = (m)p0.k(k0.n);
            i0 i00 = p0.m();
            D d0 = (D)p0.k(e.a);
            g g0 = (g)p0.k(AndroidCompositionLocals_androidKt.e);
            if(k4 == null) {
                p0.a0(0x24470A79);
                we.a a1 = a.d(k0, p0, v2 & 14);
                if(u0 instanceof F0) {
                    p0.Y();
                    if(p0.O) {
                        p0.l(a1);
                    }
                    else {
                        p0.o0();
                    }
                    a.e(p0, q1, v3, c0, d0, g0, m0, i00);
                    w.x(p0, k3, u1.k.j);
                    w.x(p0, k2, u1.k.k);
                    p0.p(true);
                    p0.p(false);
                    k5 = null;
                    goto label_67;
                }
            }
            else {
                p0.a0(607780130);
                we.a a0 = a.d(k0, p0, v2 & 14);
                if(u0 instanceof F0) {
                    p0.e0();
                    if(p0.O) {
                        p0.l(a0);
                    }
                    else {
                        p0.o0();
                    }
                    a.e(p0, q1, v3, c0, d0, g0, m0, i00);
                    w.x(p0, k4, u1.k.g);
                    w.x(p0, k3, u1.k.h);
                    w.x(p0, k2, u1.k.i);
                    p0.p(true);
                    p0.p(false);
                    k5 = k4;
                    goto label_67;
                }
            }
            w.m();
            throw null;
        }
        else {
            p0.T();
            k5 = k4;
        }
    label_67:
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new I(k0, q0, k5, k2, k3, v, v1, 2);
        }
    }

    public static final o c(P0.I i0) {
        o o0 = i0.o;
        if(o0 == null) {
            throw Y.d("Required value was null.");
        }
        return o0;
    }

    public static final we.a d(k k0, l l0, int v) {
        int v1 = ((p)l0).P;
        Object object0 = ((p)l0).k(AndroidCompositionLocals_androidKt.b);
        androidx.compose.runtime.n n0 = w.v(((p)l0));
        Object object1 = ((p)l0).k(o0.k.a);
        Object object2 = ((p)l0).k(AndroidCompositionLocals_androidKt.f);
        boolean z = ((p)l0).i(((Context)object0));
        boolean z1 = (v & 14 ^ 6) > 4 && ((p)l0).g(k0) || (v & 6) == 4;
        boolean z2 = ((p)l0).i(n0);
        boolean z3 = ((p)l0).i(((i)object1));
        boolean z4 = ((p)l0).e(v1);
        boolean z5 = ((p)l0).i(((View)object2));
        m1.i i0 = ((p)l0).N();
        if((z1 | z | z2 | z3 | z4 | z5) != 0 || i0 == androidx.compose.runtime.k.a) {
            i0 = new m1.i(((Context)object0), k0, n0, ((i)object1), v1, ((View)object2), 1);
            ((p)l0).l0(i0);
        }
        return i0;
    }

    public static final void e(l l0, q q0, int v, c c0, D d0, g g0, m m0, i0 i00) {
        P0.k.y.getClass();
        w.x(l0, i00, j.e);
        w.x(l0, q0, u1.k.l);
        w.x(l0, c0, u1.k.m);
        w.x(l0, d0, u1.k.n);
        w.x(l0, g0, u1.k.o);
        w.x(l0, m0, u1.k.r);
        h h0 = j.g;
        if(!((p)l0).O && kotlin.jvm.internal.q.b(((p)l0).N(), v)) {
            return;
        }
        d.q(v, ((p)l0), v, h0);
    }
}

