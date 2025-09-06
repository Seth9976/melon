package hd;

import Kd.g;
import ie.H;
import we.a;
import we.k;

public final class c0 implements a {
    public final int a;
    public final k b;
    public final g c;
    public final A1 d;
    public final String e;

    public c0(k k0, g g0, A1 a10, String s, int v) {
        this.a = v;
        this.b = k0;
        this.c = g0;
        this.d = a10;
        this.e = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            z0 z00 = new z0(this.c, this.d.d, this.d.e, this.e);
            this.b.invoke(z00);
            return H.a;
        }
        A0 a00 = new A0(this.c, this.d.d, this.d.e, this.e);
        this.b.invoke(a00);
        return H.a;
    }
}

