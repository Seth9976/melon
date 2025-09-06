package cd;

import X0.c;
import X0.u;
import X0.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class w1 implements k {
    public final int a;
    public final a b;

    public w1(a a0, int v) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.l(((x)object0), this.b == a.c);
                u.k(((x)object0), 4);
                u.g(((x)object0), new c(0, 1, a.c.ordinal(), 1));
                return H.a;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                u.l(((x)object0), this.b == a.d);
                u.k(((x)object0), 4);
                u.g(((x)object0), new c(0, 1, a.d.ordinal(), 1));
                return H.a;
            }
            default: {
                q.g(((x)object0), "$this$semantics");
                u.l(((x)object0), this.b == a.e);
                u.k(((x)object0), 4);
                u.g(((x)object0), new c(0, 1, a.e.ordinal(), 1));
                return H.a;
            }
        }
    }
}

