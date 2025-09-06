package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class p implements a {
    public final int a;
    public final h b;
    public final k c;
    public final gd.k d;
    public final int e;

    public p(h h0, k k0, gd.k k1, int v, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = k0;
        this.d = k1;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            L2 l20 = new L2(this.d, this.e);
            this.c.invoke(l20);
            return H.a;
        }
        h.a(this.b);
        L2 l21 = new L2(this.d, this.e);
        this.c.invoke(l21);
        return H.a;
    }
}

