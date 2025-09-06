package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class n implements a {
    public final int a;
    public final h b;
    public final k c;
    public final x d;
    public final int e;

    public n(h h0, k k0, x x0, int v, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = k0;
        this.d = x0;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            M2 m20 = new M2(this.d, this.e);
            this.c.invoke(m20);
            return H.a;
        }
        h.a(this.b);
        M2 m21 = new M2(this.d, this.e);
        this.c.invoke(m21);
        return H.a;
    }
}

