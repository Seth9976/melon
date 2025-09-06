package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class f3 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final A d;
    public final int e;

    public f3(h h0, k k0, A a0, int v, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = k0;
        this.d = a0;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(this.b);
                V2 v20 = new V2(this.d, this.e);
                this.c.invoke(v20);
                return H.a;
            }
            case 1: {
                h.a(this.b);
                X2 x20 = new X2(this.d, this.e);
                this.c.invoke(x20);
                return H.a;
            }
            default: {
                h.a(this.b);
                W2 w20 = new W2(this.d, this.e);
                this.c.invoke(w20);
                return H.a;
            }
        }
    }
}

