package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class r implements a {
    public final int a;
    public final h b;
    public final k c;
    public final w d;
    public final int e;

    public r(h h0, k k0, w w0, int v, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = k0;
        this.d = w0;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                O2 o20 = new O2(this.d, this.e);
                this.c.invoke(o20);
                return H.a;
            }
            case 1: {
                h.a(this.b);
                O2 o21 = new O2(this.d, this.e);
                this.c.invoke(o21);
                return H.a;
            }
            default: {
                h.a(this.b);
                P2 p20 = new P2(this.d, this.e);
                this.c.invoke(p20);
                return H.a;
            }
        }
    }
}

