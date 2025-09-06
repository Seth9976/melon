package v1;

import A7.d;
import I.l0;
import P0.h;
import P0.j;
import Q0.k0;
import U.M0;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import androidx.compose.runtime.A;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.n;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import gd.y1;
import java.util.UUID;
import m0.b;
import r1.c;

public abstract class i {
    public static final A a;

    static {
        i.a = new A(a.g);
    }

    public static final void a(p p0, we.a a0, q q0, b b0, l l0, int v, int v1) {
        we.a a2;
        String s;
        int v4;
        androidx.compose.runtime.p p1 = (androidx.compose.runtime.p)l0;
        p1.c0(-830247068);
        int v2 = (v & 6) == 0 ? (p1.g(p0) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p1.i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p1.g(q0) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p1.i(b0) ? 0x800 : 0x400);
        }
        if(p1.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            we.a a1 = (v1 & 2) == 0 ? a0 : null;
            View view0 = (View)p1.k(AndroidCompositionLocals_androidKt.f);
            c c0 = (c)p1.k(k0.h);
            Object object0 = p1.k(i.a);
            Object object1 = p1.k(k0.n);
            n n0 = w.v(p1);
            b0 b00 = w.w(b0, p1);
            boolean z = false;
            UUID uUID0 = (UUID)d5.w.P(new Object[0], null, null, a.h, p1, 0xC00, 6);
            m m0 = p1.N();
            V v3 = k.a;
            if(m0 == v3) {
                v4 = v2;
                s = (String)object0;
                m m1 = new m(a1, q0, s, view0, c0, p0, uUID0);
                m1.i(n0, new b(0x4DA88F2F, new B2.p(25, m1, b00), true));
                p1.l0(m1);
                m0 = m1;
            }
            else {
                v4 = v2;
                s = (String)object0;
            }
            boolean z1 = p1.i(m0);
            boolean z2 = p1.g(s);
            boolean z3 = p1.g(((r1.m)object1));
            l0 l00 = p1.N();
            if((z1 | (v4 & 0x70) == 0x20 | ((v4 & 0x380) == 0x100 ? 1 : 0) | z2 | z3) != 0 || l00 == v3) {
                l0 l01 = new l0(m0, a1, q0, s, ((r1.m)object1), 4);
                p1.l0(l01);
                l00 = l01;
            }
            J.b(m0, l00, p1);
            boolean z4 = p1.i(m0);
            boolean z5 = p1.g(s);
            boolean z6 = p1.g(((r1.m)object1));
            v1.b b1 = p1.N();
            if(((v4 & 0x70) == 0x20 | z4 | ((v4 & 0x380) == 0x100 ? 1 : 0) | z5 | z6) != 0 || b1 == v3) {
                v1.b b2 = new v1.b(m0, a1, q0, s, ((r1.m)object1));
                p1.l0(b2);
                b1 = b2;
            }
            J.h(b1, p1);
            boolean z7 = p1.i(m0);
            if((v4 & 14) == 4) {
                z = true;
            }
            y1 y10 = p1.N();
            if(z7 || z || y10 == v3) {
                y10 = new y1(29, m0, p0);
                p1.l0(y10);
            }
            J.b(p0, y10, p1);
            boolean z8 = p1.i(m0);
            e e0 = p1.N();
            if(z8 || e0 == v3) {
                e0 = new e(m0, null);
                p1.l0(e0);
            }
            J.d(p1, m0, e0);
            boolean z9 = p1.i(m0);
            f f0 = p1.N();
            if(z9 || f0 == v3) {
                f0 = new f(m0, 0);
                p1.l0(f0);
            }
            r0.q q1 = androidx.compose.ui.layout.a.d(r0.n.a, f0);
            boolean z10 = p1.i(m0);
            boolean z11 = p1.g(((r1.m)object1));
            M0 m00 = p1.N();
            if(z10 || z11 || m00 == v3) {
                m00 = new M0(1, m0, ((r1.m)object1));
                p1.l0(m00);
            }
            int v5 = p1.P;
            i0 i00 = p1.m();
            r0.q q2 = r0.a.d(p1, q1);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p1.e0();
            if(p1.O) {
                p1.l(i0);
            }
            else {
                p1.o0();
            }
            w.x(p1, m00, j.f);
            w.x(p1, i00, j.e);
            h h0 = j.g;
            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v5)) {
                d.q(v5, p1, v5, h0);
            }
            w.x(p1, q2, j.d);
            p1.p(true);
            a2 = a1;
        }
        else {
            p1.T();
            a2 = a0;
        }
        n0 n00 = p1.t();
        if(n00 != null) {
            n00.d = new g(p0, a2, q0, b0, v, v1);
        }
    }

    public static final boolean b(View view0) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getRootView().getLayoutParams();
        WindowManager.LayoutParams windowManager$LayoutParams0 = viewGroup$LayoutParams0 instanceof WindowManager.LayoutParams ? ((WindowManager.LayoutParams)viewGroup$LayoutParams0) : null;
        return windowManager$LayoutParams0 != null && (windowManager$LayoutParams0.flags & 0x2000) != 0;
    }
}

