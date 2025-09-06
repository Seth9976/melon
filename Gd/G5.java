package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class g5 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final j5 d;

    public g5(h h0, j5 j50, k k0) {
        this.a = 0;
        super();
        this.b = h0;
        this.d = j50;
        this.c = k0;
    }

    public g5(h h0, k k0, j5 j50) {
        this.a = 1;
        super();
        this.b = h0;
        this.c = k0;
        this.d = j50;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            k k0 = this.c;
            if(k0 != null) {
                k0.invoke(new k5(this.d.g));
            }
            return H.a;
        }
        h.a(this.b);
        String s = this.d.c;
        if(s != null) {
            k k1 = this.c;
            if(k1 != null) {
                k1.invoke(new l5(s));
            }
        }
        return H.a;
    }
}

