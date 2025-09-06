package rd;

import E9.g;
import W.p;
import ie.H;
import kotlin.jvm.internal.q;
import r1.f;
import we.k;
import x1.d;
import x1.e;
import x1.n;

public final class m implements k {
    public final int a;
    public final e b;
    public final e c;
    public final float d;

    public m(e e0, e e1, float f, int v) {
        this.a = v;
        this.b = e0;
        this.c = e1;
        this.d = f;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((d)object0), "$this$constrainAs");
            p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
            p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
            d.a(((d)object0), this.b.g, this.c.e);
            ((d)object0).d(new n(null, "spread"));
            n n0 = new n(null, "spread");
            n0.c.getClass();
            n0.c.b = new f(this.d);
            n0.c.c = null;
            ((d)object0).c(n0);
            return H.a;
        }
        q.g(((d)object0), "$this$constrainAs");
        p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
        p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
        g.v(((d)object0).e, this.b.g, 0.0f, 6);
        g.v(((d)object0).g, this.c.e, this.d, 4);
        ((d)object0).c(new n(null, "spread"));
        ((d)object0).d(new n(null, "spread"));
        return H.a;
    }
}

