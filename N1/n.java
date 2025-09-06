package n1;

import G.t0;
import Ic.h;
import ie.H;
import ie.m;
import kotlin.jvm.internal.r;
import o1.a;
import we.k;

public final class n extends r implements k {
    public final t0 f;
    public final h g;
    public final q h;

    public n(t0 t00, h h0, q q0) {
        this.f = t00;
        this.g = h0;
        this.h = q0;
        super(1);
    }

    public final void d() {
        kotlin.jvm.internal.q.e(this.f, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Boolean>");
        c c0 = new c(this.f);
        this.g.invoke();
        a a0 = new a(c0);
        m m0 = kotlin.jvm.internal.q.b(((String)a0.c), "Enter") ? new m(Boolean.FALSE, Boolean.TRUE) : new m(Boolean.TRUE, Boolean.FALSE);
        ((Boolean)m0.a).getClass();
        ((Boolean)m0.b).getClass();
        c0.a.j(((Boolean)m0.a), ((Boolean)m0.b));
        this.h.b.put(c0, a0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        this.d();
        return H.a;
    }
}

