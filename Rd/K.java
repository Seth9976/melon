package rd;

import E9.g;
import W.p;
import ie.H;
import kotlin.jvm.internal.q;
import r1.f;
import x1.d;
import x1.e;
import x1.n;

public final class k implements we.k {
    public final e a;
    public final float b;

    public k(e e0, float f) {
        this.a = e0;
        this.b = f;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$constrainAs");
        p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
        p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
        g.v(((d)object0).e, this.a.g, 0.0f, 6);
        ((d)object0).d(new n(null, "spread"));
        ((d)object0).c(new n(new f(this.b), null));
        return H.a;
    }
}

