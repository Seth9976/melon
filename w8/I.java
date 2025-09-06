package w8;

import B2.l;
import B2.n;
import Cc.e0;
import E9.w;
import H0.e;
import J2.c;
import J2.s;
import V4.u;
import Vc.f;
import a.a;
import androidx.compose.runtime.J;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import com.iloen.melon.playback.Actor;
import ie.H;
import kc.s2;
import ob.z;
import we.o;

public final class i implements o {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final z d;
    public final s2 e;
    public final boolean f;
    public final w0 g;

    public i(boolean z, boolean z1, w0 w00, z z2, s2 s20, boolean z3, int v) {
        this.a = v;
        this.b = z;
        this.c = z1;
        this.g = w00;
        this.d = z2;
        this.e = s20;
        this.f = z3;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        c c3;
        c c1;
        H h0 = H.a;
        w0 w00 = this.g;
        boolean z = this.c;
        boolean z1 = this.b;
        l l0 = l.a;
        if(this.a != 0) {
            Actor actor0 = ((q)w00).j;
            ((Integer)object2).getClass();
            kotlin.jvm.internal.q.g(((s)object0), "$this$Row");
            a.i((z1 ? ((s)object0).a(l0) : u.J(l0, 0.0f)), ((androidx.compose.runtime.l)object1), 0);
            boolean z2 = this.f;
            c c0 = c.d;
            if(z) {
                ((p)(((androidx.compose.runtime.l)object1))).a0(0xF066778E);
                e.a(e0.U(u.G(44.0f), new E2.i(w.A(actor0), true)), c0, m0.c.e(0x3F9080D1, ((p)(((androidx.compose.runtime.l)object1))), new f(z2, 3, 0)), ((p)(((androidx.compose.runtime.l)object1))), 0x180, 0);
                c1 = c0;
            }
            else {
                c1 = c0;
                ((p)(((androidx.compose.runtime.l)object1))).a0(0xF06FEB9D);
                a.i(u.G(44.0f), ((p)(((androidx.compose.runtime.l)object1))), 0);
            }
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
            a.i((z1 ? ((s)object0).a(l0) : u.J(l0, 8.0f)), ((androidx.compose.runtime.l)object1), 0);
            ((q)w00).k(this.d, this.e, z2, null, null, ((androidx.compose.runtime.l)object1), 0, 24);
            a.i((z1 ? ((s)object0).a(l0) : u.J(l0, 8.0f)), ((androidx.compose.runtime.l)object1), 0);
            if(z) {
                ((p)(((androidx.compose.runtime.l)object1))).a0(0xF077126E);
                e.a(e0.U(u.G(44.0f), new E2.i(w.y(actor0), true)), c1, m0.c.e(0x674291C8, ((p)(((androidx.compose.runtime.l)object1))), new f(z2, 4, 0)), ((p)(((androidx.compose.runtime.l)object1))), 0x180, 0);
            }
            else {
                ((p)(((androidx.compose.runtime.l)object1))).a0(0xF080867D);
                a.i(u.G(44.0f), ((p)(((androidx.compose.runtime.l)object1))), 0);
            }
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
            a.i((z1 ? ((s)object0).a(l0) : u.J(l0, 0.0f)), ((androidx.compose.runtime.l)object1), 0);
            return h0;
        }
        Actor actor1 = ((m)w00).j;
        ((Integer)object2).getClass();
        kotlin.jvm.internal.q.g(((s)object0), "$this$Row");
        n n0 = z1 ? ((s)object0).a(l0) : u.J(l0, 0.0f);
        p p0 = (p)(((androidx.compose.runtime.l)object1));
        if(p0.N() == k.a) {
            p0.l0(J.i(p0));
        }
        a.i(n0, p0, 0);
        boolean z3 = this.f;
        c c2 = c.d;
        if(z) {
            p0.a0(0xC7F20BF5);
            e.a(e0.U(u.G(44.0f), new E2.i(w.A(actor1), true)), c2, m0.c.e(965493011, p0, new f(z3, 1, 0)), p0, 0x180, 0);
            c3 = c2;
        }
        else {
            c3 = c2;
            p0.a0(0xC7FBD65B);
            a.i(u.G(44.0f), p0, 0);
        }
        p0.p(false);
        a.i(n0, p0, 0);
        ((m)w00).k(this.d, this.e, z3, null, null, p0, 0, 24);
        a.i(n0, p0, 0);
        if(z) {
            p0.a0(0xC800C655);
            e.a(e0.U(u.G(44.0f), new E2.i(w.y(actor1), true)), c3, m0.c.e(0x613E520A, p0, new f(z3, 2, 0)), p0, 0x180, 0);
        }
        else {
            p0.a0(0xC80A90BB);
            a.i(u.G(44.0f), p0, 0);
        }
        p0.p(false);
        a.i(n0, p0, 0);
        return h0;
    }
}

