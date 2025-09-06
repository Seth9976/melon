package w8;

import B2.h;
import B2.n;
import Cc.e0;
import E2.i;
import H0.e;
import J2.c;
import V4.u;
import a.a;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.playback.Actor;
import ie.H;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import ob.z;
import oc.M;
import r1.f;
import we.o;

public final class s implements o {
    public final boolean a;
    public final boolean b;
    public final s2 c;
    public final A d;
    public final boolean e;
    public final z f;
    public final boolean g;
    public final boolean h;

    public s(boolean z, boolean z1, s2 s20, A a0, boolean z2, z z3, boolean z4, boolean z5) {
        this.a = z;
        this.b = z1;
        this.c = s20;
        this.d = a0;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        c c2;
        boolean z4;
        c c1;
        boolean z2;
        float f4;
        float f1;
        A a0 = this.d;
        Actor actor0 = this.d.j;
        ((Integer)object2).getClass();
        q.g(((J2.s)object0), "$this$Row");
        p p0 = (p)(((l)object1));
        Object object3 = p0.k(h.b);
        float f = r1.h.b(((r1.h)p0.k(h.a)).a);
        boolean z = this.a;
        if(z) {
            f f2 = new f(44.0f);
            f f3 = new f((f - 92.0f) / 5.0f);
            if(f2.compareTo(f3) > 0) {
                f2 = f3;
            }
            f1 = f2.a;
        }
        else {
            f1 = 44.0f;
        }
        if(z) {
            f f5 = new f(28.0f);
            f f6 = new f((f - 92.0f) / 5.0f);
            if(f5.compareTo(f6) > 0) {
                f5 = f6;
            }
            f4 = f5.a;
        }
        else {
            f4 = 28.0f;
        }
        B2.l l0 = B2.l.a;
        s2 s20 = this.c;
        boolean z1 = this.g;
        c c0 = c.d;
        if(this.b) {
            p0.a0(1909886418);
            z2 = z1;
            boolean z3 = ((Boolean)w.e(((d3)s20).c(), Boolean.FALSE, null, p0, 0x30, 2).getValue()).booleanValue();
            c1 = c0;
            e.a(u.G(f1).b(e0.U(l0, new i(E9.w.x(actor0), false))), c1, m0.c.e(0x646B092B, p0, new r(z3, z2, f4, ((Context)object3))), p0, 0x180, 0);
        }
        else {
            z2 = z1;
            c1 = c0;
            p0.a0(1910938558);
            a.i(u.G(f1), p0, 0);
        }
        p0.p(false);
        a.i((z ? ((J2.s)object0).a(l0) : u.J(l0, 8.0f)), p0, 0);
        if(this.e) {
            p0.a0(0x71EACC83);
            z4 = true;
            e.a(e0.U(u.G(f1), new i(E9.w.A(actor0), false)), c1, m0.c.e(-1517853406, p0, new w8.u(z2, f4, ((Context)object3), 0)), p0, 0x180, 0);
            c2 = c1;
        }
        else {
            c2 = c1;
            z4 = false;
            p0.a0(0x71F5713E);
            a.i(u.G(f1), p0, 0);
        }
        p0.p(false);
        a.i((z ? ((J2.s)object0).a(l0) : u.J(l0, 8.0f)), p0, 0);
        n n0 = u.G(f1);
        n n1 = u.G(f4);
        a0.k(this.f, s20, z2, n0, n1, p0, 0, 0);
        a.i((z ? ((J2.s)object0).a(l0) : u.J(l0, 8.0f)), p0, 0);
        if(z4) {
            p0.a0(0x71FF20C2);
            e.a(e0.U(u.G(f1), new i(E9.w.y(actor0), false)), c2, m0.c.e(645448803, p0, new w8.u(z2, f4, ((Context)object3), 1)), p0, 0x180, 0);
        }
        else {
            p0.a0(0x720A415E);
            a.i(u.G(f1), p0, 0);
        }
        p0.p(false);
        a.i((z ? ((J2.s)object0).a(l0) : u.J(l0, 8.0f)), p0, 0);
        if(this.h) {
            p0.a0(0x720E91FC);
            M m0 = (M)w.e(((d3)s20).d(), M.a, null, p0, 0x30, 2).getValue();
            e.a(u.G(f1).b(e0.U(l0, new i(E9.w.w(actor0), false))), c2, m0.c.e(0xA76A23A4, p0, new v(m0, z2, f4, ((Context)object3))), p0, 0x180, 0);
        }
        else {
            p0.a0(1914938302);
            a.i(u.G(f1), p0, 0);
        }
        p0.p(false);
        a.i(u.J(l0, (z ? 10.0f : 8.0f)), p0, 0);
        return H.a;
    }
}

