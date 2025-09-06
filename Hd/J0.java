package hd;

import Kd.g;
import ie.H;
import we.a;
import we.k;

public final class j0 implements a {
    public final int a;
    public final k b;
    public final g c;
    public final String d;

    public j0(k k0, g g0, String s, int v) {
        this.a = v;
        this.b = k0;
        this.c = g0;
        this.d = s;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                E0 e00 = new E0(this.c, this.d);
                this.b.invoke(e00);
                return H.a;
            }
            case 1: {
                D0 d00 = new D0(this.c, this.d);
                this.b.invoke(d00);
                return H.a;
            }
            case 2: {
                I0 i00 = new I0(this.c, this.d);
                this.b.invoke(i00);
                return H.a;
            }
            default: {
                H0 h00 = new H0(this.c, this.d);
                this.b.invoke(h00);
                return H.a;
            }
        }
    }
}

