package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class g implements a {
    public final int a;
    public final h b;
    public final k c;
    public final t d;

    public g(h h0, k k0, t t0, int v) {
        this.a = v;
        this.b = h0;
        this.c = k0;
        this.d = t0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            F2 f20 = new F2(this.d, true);
            this.c.invoke(f20);
            return H.a;
        }
        h.a(this.b);
        F2 f21 = new F2(this.d, false);
        this.c.invoke(f21);
        return H.a;
    }
}

