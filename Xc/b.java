package xc;

import Hc.P;
import Ic.J;
import ie.H;
import wc.x;
import we.a;

public final class b implements a {
    public final int a;
    public final k b;

    public b(k k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            ((x)this.b.getViewModel()).y(false);
            return H.a;
        }
        k k0 = this.b;
        Object object0 = ((x)k0.getViewModel()).d.getValue();
        P p0 = object0 instanceof P ? ((P)object0) : null;
        if(p0 != null) {
            k0.sendUserEvent(new J(!p0.b));
        }
        return H.a;
    }
}

