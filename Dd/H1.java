package Dd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class h1 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final r1 d;

    public h1(h h0, k k0, r1 r10, int v) {
        this.a = v;
        this.b = h0;
        this.c = k0;
        this.d = r10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            u1 u10 = new u1(this.d.b);
            this.c.invoke(u10);
            return H.a;
        }
        h.a(this.b);
        v1 v10 = new v1(this.d.a);
        this.c.invoke(v10);
        return H.a;
    }
}

