package n1;

import ie.H;
import kotlin.jvm.internal.r;
import o1.c;
import we.k;

public final class o extends r implements k {
    public final h f;
    public final q g;

    public o(h h0, q q0) {
        this.f = h0;
        this.g = q0;
        super(1);
    }

    public final void d() {
        n1.k k0 = n1.k.c ? new n1.k(this.f.a) : null;
        if(k0 != null) {
            c c0 = new c(k0, new X.k(this.g, 24));
            this.g.d.put(k0, c0);
        }
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        this.d();
        return H.a;
    }
}

