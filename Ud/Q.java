package ud;

import E9.g;
import W.p;
import ie.H;
import we.k;
import x1.d;

public final class q implements k {
    public final int a;
    public static final q b;
    public static final q c;
    public static final q d;

    static {
        q.b = new q(0);
        q.c = new q(1);
        q.d = new q(2);
    }

    public q(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                kotlin.jvm.internal.q.g(((d)object0), "$this$constrainAs");
                p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
                g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                g.v(((d)object0).g, ((d)object0).c.g, 0.0f, 6);
                return H.a;
            }
            case 1: {
                kotlin.jvm.internal.q.g(((d)object0), "$this$constrainAs");
                p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
                g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                g.v(((d)object0).g, ((d)object0).c.g, 0.0f, 6);
                return H.a;
            }
            default: {
                kotlin.jvm.internal.q.g(((d)object0), "$this$constrainAs");
                p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
                p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
                g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                g.v(((d)object0).g, ((d)object0).c.g, 0.0f, 6);
                return H.a;
            }
        }
    }
}

