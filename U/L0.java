package U;

import J0.u;
import J0.v;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import x0.b;

public final class l0 extends r implements k {
    public final int f;
    public final t0 g;

    public l0(t0 t00, int v) {
        this.f = v;
        this.g = t00;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            long v = u.g(((v)object0), false);
            this.g.d(v);
            ((v)object0).a();
            return H.a;
        }
        this.g.b(((b)object0).a);
        return H.a;
    }
}

