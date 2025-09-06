package gd;

import ie.H;
import w0.h;
import we.a;
import we.k;

public final class i implements a {
    public final int a;
    public final h b;
    public final k c;
    public final v d;
    public final int e;

    public i(h h0, k k0, v v0, int v1, int v2) {
        this.a = v2;
        this.b = h0;
        this.c = k0;
        this.d = v0;
        this.e = v1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            I2 i20 = new I2(this.d, this.e);
            this.c.invoke(i20);
            return H.a;
        }
        h.a(this.b);
        H2 h20 = new H2(this.d, this.e);
        this.c.invoke(h20);
        return H.a;
    }
}

