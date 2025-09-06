package Rc;

import E9.g;
import W.p;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import x1.d;
import x1.n;

public final class v implements k {
    public final int a;
    public static final v b;
    public static final v c;
    public static final v d;

    static {
        v.b = new v(0);
        v.c = new v(1);
        v.d = new v(2);
    }

    public v(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "$this$constrainAs");
                g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
                p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
                ((d)object0).d(new n(null, "spread"));
                ((d)object0).c(new n(null, "1:1"));
                return H.a;
            }
            case 1: {
                q.g(((d)object0), "$this$constrainAs");
                g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
                p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
                ((d)object0).d(new n(null, "spread"));
                ((d)object0).c(new n(null, "1:1"));
                return H.a;
            }
            default: {
                q.g(((d)object0), "$this$constrainAs");
                g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
                p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
                ((d)object0).d(new n(null, "spread"));
                ((d)object0).c(new n(null, "16:9"));
                return H.a;
            }
        }
    }
}

