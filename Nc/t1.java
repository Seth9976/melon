package Nc;

import ie.H;
import w0.h;
import we.a;

public final class t1 implements a {
    public final int a;
    public final h b;
    public final v1 c;

    public t1(h h0, v1 v10, int v) {
        this.a = v;
        this.b = h0;
        this.c = v10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                z1 z10 = new z1(this.c);
                this.c.k.invoke(z10);
                return H.a;
            }
            case 1: {
                h.a(this.b);
                y1 y10 = new y1(this.c);
                this.c.k.invoke(y10);
                return H.a;
            }
            default: {
                h.a(this.b);
                x1 x10 = new x1(this.c);
                this.c.k.invoke(x10);
                return H.a;
            }
        }
    }
}

