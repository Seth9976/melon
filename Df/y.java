package df;

import Gf.m;
import Gf.p;
import Me.L;
import Se.t;
import af.h;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import we.a;

public final class y implements a {
    public final int a;
    public final C b;
    public final t c;
    public final H d;

    public y(C c0, t t0, H h0, int v) {
        this.a = v;
        this.b = c0;
        this.c = t0;
        this.d = h0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h h0 = ((cf.a)this.b.b.a).h;
            L l0 = (L)this.d.a;
            h0.getClass();
            q.g(this.c, "field");
            q.g(l0, "descriptor");
            return null;
        }
        p p0 = ((cf.a)this.b.b.a).a;
        y y0 = new y(this.b, this.c, this.d, 1);
        ((m)p0).getClass();
        return new Gf.h(((m)p0), y0);
    }
}

