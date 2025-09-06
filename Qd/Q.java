package qd;

import E9.g;
import W.p;
import ie.H;
import r1.f;
import we.k;
import x1.d;
import x1.n;

public final class q implements k {
    public final int a;
    public static final q b;
    public static final q c;

    static {
        q.b = new q(0);
        q.c = new q(1);
    }

    public q(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            kotlin.jvm.internal.q.g(((d)object0), "$this$constrainAs");
            p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
            p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
            g.v(((d)object0).g, ((d)object0).c.g, 11.0f, 4);
            return H.a;
        }
        kotlin.jvm.internal.q.g(((d)object0), "$this$constrainAs");
        p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
        p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
        g.v(((d)object0).g, ((d)object0).c.g, 16.0f, 4);
        ((d)object0).d(new n(null, "spread"));
        ((d)object0).c(new n(new f(36.0f), null));
        return H.a;
    }
}

