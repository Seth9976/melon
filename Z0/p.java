package z0;

import P4.a;
import kotlin.jvm.internal.r;
import we.k;

public final class p extends r implements k {
    public final int f;
    public final q g;

    public p(q q0, int v) {
        this.f = v;
        this.g = q0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            return a.h(this.g.k.a(((Number)object0).doubleValue()), this.g.e, this.g.f);
        }
        double f = a.h(((Number)object0).doubleValue(), this.g.e, this.g.f);
        return this.g.n.a(f);
    }
}

